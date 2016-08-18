package org.light32.projects.m8b.service;

import org.light32.projects.m8b.Magic8Ball;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping(value = "/m8b")
public class Magic8BallService {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private final Magic8Ball magic8Ball = new Magic8Ball();

    public static void main(String[] args) {   	
    	SpringApplication.run(Magic8BallService.class, args);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/ask")
    Answer ask() {
        log.info("Magic8BallService : ask");
        return new Answer(magic8Ball.ask());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/ask")
    AskResponse ask(@RequestBody Question question) {
        log.info("Magic8BallService : ask");
        Answer answer = new Answer(magic8Ball.ask());
        return new AskResponse(question, answer);
    }
}