package com.learnsleek.controller;

import com.learnsleek.dto.PolicyDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(path = "/policy")
@Controller
public class PolicyController {
    private static final Logger logger = LoggerFactory.getLogger(PolicyController.class);

    @PostMapping(path="/get", consumes = "application/json")
    public ResponseEntity<PolicyDto> auth(@RequestBody PolicyDto userdto)
    {
        PolicyDto policy = new PolicyDto();
        policy.setPolicyNumber("AM1019");
        return new ResponseEntity<PolicyDto>(policy, HttpStatus.OK);
    }

    @GetMapping(path="/get", produces = "application/json")
    public ResponseEntity<PolicyDto> auth()
    {
        PolicyDto policy = new PolicyDto();
        policy.setPolicyNumber("AM1020");
        return new ResponseEntity<PolicyDto>(policy, HttpStatus.OK);
    }

}
