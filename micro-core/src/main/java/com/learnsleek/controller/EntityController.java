package com.learnsleek.controller;

import com.learnsleek.dto.ApplicationDTO;
import com.learnsleek.dto.PolicyDto;
import com.learnsleek.dto.RequestDTO;
import com.learnsleek.exception.APIRequestException;
import com.learnsleek.exception.BusinessException;
import com.learnsleek.service.policy.IPolicyApplicationService;
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

    @Autowired
    IPolicyApplicationService policyApplicationService;


    @PostMapping(path="/policy", consumes = "application/json")
    public ResponseEntity<PolicyDto> policyDetails(
            @Valid @NotNull @RequestBody PolicyDto policyDtoReq)
    {
        PolicyDto policyDtoRes = null;
        try {
            policyDtoRes = policyApplicationService.getPolicyApplication(policyDtoReq);
        } catch (BusinessException ex){
            logger.error(ex.getMessage());
           throw new APIRequestException("Business Exception!", ex);
        }catch (Exception ex){
            logger.error(ex.toString());
            throw new APIRequestException("UnHandled Exception!", ex);
        }
        return new ResponseEntity<PolicyDto>(policyDtoRes, HttpStatus.OK);
    }

    @PostMapping(path="/application", consumes = "application/json")
    public ResponseEntity<ApplicationDTO> applicationDetails(@Valid @NotNull @RequestBody RequestDTO requestDTO)
    {
        ApplicationDTO applicationDTO = new ApplicationDTO();
        return new ResponseEntity<ApplicationDTO>(applicationDTO, HttpStatus.OK);
    }


    @GetMapping(path="/get", produces = "application/json")
    public ResponseEntity<PolicyDto> auth()
    {
        PolicyDto policy = new PolicyDto();
        policy.setPolicyNumber("AM1020");
        return new ResponseEntity<PolicyDto>(policy, HttpStatus.OK);
    }

}
