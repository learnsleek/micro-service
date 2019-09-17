package com.learnsleek.controller;

import com.learnsleek.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;


@RestController
@RequestMapping(path = "/auth")
public class AuthController {
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @PostMapping(path="/user", consumes = "application/json")
    public String auth(@RequestBody UserDto userdto)
    {
        logger.debug("Called Auth Controller !!", userdto.toString());
        return "Hello World!";
    }

}
