package com.learnsleek.controller;

import com.learnsleek.dto.PolicyDto;
import com.learnsleek.exception.APIRequestException;
import com.learnsleek.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;


@RestController
@RequestMapping(path = "/entity")
@Controller
public class EntityController {
    private static final Logger logger = LoggerFactory.getLogger(EntityController.class);



    @GetMapping(path="/get", produces = "application/json")
    public ResponseEntity<PolicyDto> auth()
    {
        PolicyDto policy = new PolicyDto();
        policy.setPolicyNumber("AM1020");
        logger.info("policy" + policy.getPolicyNumber());
        return new ResponseEntity<PolicyDto>(policy, HttpStatus.OK);
    }


    @GetMapping(path="/get1", produces = "application/json")
    public ResponseEntity<PolicyDto> authNonSec(@RequestHeader("Test") String headers)
    {
        logger.info("LOG Header :: " , headers );
        PolicyDto policy = new PolicyDto();
        policy.setPolicyNumber("AM1020");
        return new ResponseEntity<PolicyDto>(policy, HttpStatus.OK);
    }

}
