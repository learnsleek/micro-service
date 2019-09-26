package com.learnsleek.service.user;


import com.learnsleek.dao.user.IUserDao;
import com.learnsleek.model.CustomUser;
import com.learnsleek.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public class UserServiceImpl implements IUserService {


    @Autowired
    IUserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity userEntity = null;

        try {
            userEntity = userDao.getUserDetails(username);

            if (userEntity != null && userEntity.getId() != null && !"".equalsIgnoreCase(userEntity.getId())) {
                CustomUser customUser = new CustomUser(userEntity);
                return customUser;
            } else {
                throw new UsernameNotFoundException("User " + username + " was not found in the database");
            }
        } catch (Exception e) {
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }

    }
}