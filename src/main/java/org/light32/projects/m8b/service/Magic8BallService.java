package org.light32.projects.m8b.service;

import org.light32.projects.m8b.Magic8Ball;
import org.light32.projects.m8b.service.exception.RepositoryOfflineException;
import org.light32.projects.m8b.service.mongo.Magic8BallRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping(value = "/m8b")
public class Magic8BallService {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private final Magic8Ball magic8Ball = new Magic8Ball();

    @Autowired
    Magic8BallRepository m8bRepository;
    private boolean m8bRepositoryAvailable = true;

    public static void main(String[] args) {   	
    	SpringApplication.run(Magic8BallService.class, args);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/roll")
    Answer roll() {
        log.info("Magic8BallService : roll");
        AskResponse resp = new AskResponse(Question.BLANK, new Answer(magic8Ball.ask()));
        storeResponse(resp);
        return resp.getAnswer();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/ask/{id}")
    AskResponse ask(@PathVariable String id) throws RepositoryOfflineException {
        log.info("Magic8BallService : ask id=[" + id + "]");

        if (!m8bRepositoryAvailable) {
            throw new RepositoryOfflineException("db not available");
        }

        try {
            AskResponse result = m8bRepository.findById(id);
        } catch (Exception e) {
            m8bRepositoryAvailable = false;
            log.error("caught exception [" + e.getMessage() + "], disabling db access", e);
            throw e;
        }
        return m8bRepository.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/ask")
    AskResponse ask(@RequestBody Question question) {
        log.info("Magic8BallService : ask");
        Answer answer = new Answer(magic8Ball.ask());
        AskResponse response = new AskResponse(question, answer);
        storeResponse(response);
        return response;
    }

    private void storeResponse(AskResponse response) {
        if (m8bRepositoryAvailable) {
            try {
                m8bRepository.save(response);
            } catch (Exception e) {
                m8bRepositoryAvailable = false;
                log.error("caught exception [" + e.getMessage() + "], disabling response logging", e);
                throw e;
            }
        }
    }
}