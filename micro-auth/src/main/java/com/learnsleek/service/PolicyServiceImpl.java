package com.learnsleek.service;

import com.learnsleek.dto.PolicyDTO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PolicyServiceImpl implements  IPolicyService{

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallBackPolicy")
    public PolicyDTO getPolicyDetails() {

        PolicyDTO policy = restTemplate.getForObject("http://core-service/policy/get", PolicyDTO.class);
        return policy;
    }

    public PolicyDTO getFallBackPolicy() {

        PolicyDTO policy = new PolicyDTO();
        policy.setPolicyNumber("HARDCODED From FallBack");
        return policy;
    }


}
