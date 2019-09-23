package com.learnsleek.service.user;

import com.learnsleek.dto.UserDTO;
import com.learnsleek.exception.BusinessException;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {

    UserDTO getUserByUserName() throws BusinessException;

}
