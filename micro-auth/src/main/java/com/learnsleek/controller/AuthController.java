package com.learnsleek.controller;


import com.learnsleek.dto.PolicyDTO;
import com.learnsleek.dto.UserDto;
import com.learnsleek.service.IPolicyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/auth")
public class AuthController {
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    IPolicyService policyService;

    @PostMapping(path="/user", consumes = "application/json")
    public ResponseEntity<PolicyDTO> auth(@RequestBody UserDto userdto)
    {
        PolicyDTO policyDTO = policyService.getPolicyDetails();
        return new ResponseEntity<PolicyDTO>(policyDTO, HttpStatus.OK);
    }

}
