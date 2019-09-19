package com.learnsleek.service.policy;

import com.learnsleek.dto.PolicyDto;
import com.learnsleek.exception.BusinessException;

public interface IPolicyApplicationService {

    PolicyDto getPolicyApplication(PolicyDto policyDtoReq) throws BusinessException;
}
