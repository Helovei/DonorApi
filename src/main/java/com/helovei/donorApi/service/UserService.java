package com.helovei.donorApi.service;

import com.helovei.donorApi.model.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends AbstractCrudService<UserEntity>, UserDetailsService {

    UserEntity findByLoginAndPassword(String username, String password);

}
