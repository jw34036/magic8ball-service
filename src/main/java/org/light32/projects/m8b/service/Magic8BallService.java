package org.light32.projects.m8b.service;

import org.light32.projects.m8b.Magic8Ball;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Magic8BallService {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private final Magic8Ball magic8Ball = new Magic8Ball();

    public static void main(String[] args) {   	
    	SpringApplication.run(Magic8BallService.class, args);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/ask")
    AskResponse ask() { 
    	log.info("Magic8BallService : ask");
    	return new AskResponse(magic8Ball.ask());
    }
    
    
}