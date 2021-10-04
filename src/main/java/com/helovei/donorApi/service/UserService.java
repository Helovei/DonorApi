package com.helovei.donorApi.service;

import com.helovei.donorApi.model.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    Iterable<UserEntity> getAll();

    boolean save(UserEntity user);

    UserEntity findUserByUsernameAndPassword(String username, String password);
}
