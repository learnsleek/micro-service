package com.learnsleek.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping(path = "/")
public class HomeController {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping({ "/hello" })
    public String hello() {
        logger.trace("From Hello!!");
        return "Hello World";
    }

    @RequestMapping("/core")
    @PreAuthorize("hasRole('ROLE_VIEW_NOTE')")
    public String hi() {
        String randomString = this.restTemplate.getForObject("http://core-service/entity/get", String.class);
        logger.info("logger" + randomString);
        return "Server Response :: " + randomString;
    }

}