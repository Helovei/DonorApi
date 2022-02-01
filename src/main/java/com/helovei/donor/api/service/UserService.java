package com.helovei.donor.api.service;

import com.helovei.donor.api.model.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends AbstractCrudService<UserEntity>, UserDetailsService {

    UserEntity findByLoginAndPassword(String username, String password);

}
