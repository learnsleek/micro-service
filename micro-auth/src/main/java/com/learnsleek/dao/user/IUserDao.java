package com.learnsleek.dao.user;

import com.learnsleek.model.UserEntity;

public interface IUserDao {

    public UserEntity getUserDetails(String username);
}


