package com.learnsleek.service.policy;

import com.learnsleek.dto.PolicyDto;
import com.learnsleek.exception.BusinessException;
import com.learnsleek.exception.PersistentException;
import com.learnsleek.model.Policy;
import com.learnsleek.persist.IPolicyPersist;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PolicyApplicationServiceImpl implements IPolicyApplicationService {

    private static final Logger logger = LoggerFactory.getLogger(PolicyApplicationServiceImpl.class);


    @Autowired
    IPolicyPersist policyService;

    @Override
    public PolicyDto getPolicyApplication(PolicyDto policyDto) throws BusinessException {
        Policy policy = null;
        PolicyDto policyDtoResp = null;
        try {
            policy =  policyService.getPolicyDetailFromCore(policyDto.getEntityVal());
            //Parse Using PolicyDTOParser
            policyDtoResp =new PolicyDto();
            policyDtoResp.setPolicyNumber(policy.getPolicyNumber());
        }catch(PersistentException ex){
            logger.error("getPolicyApplication : -" + ex.getMessage());
            throw new PersistentException("getPolicyApplication", ex);
        }catch (Exception ex){
            logger.error("getPolicyApplication : -" + ex.getMessage());
            throw new PersistentException("getPolicyApplication", ex);
        }
        return policyDtoResp;
    }
}
