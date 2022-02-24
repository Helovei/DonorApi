package com.helovei.donor.api.service.impl;

import com.helovei.donor.api.model.RoleEntity;
import com.helovei.donor.api.model.UserEntity;
import com.helovei.donor.api.repository.UserRepository;
import com.helovei.donor.api.service.RoleService;
import com.helovei.donor.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl extends AbstractServiceImpl<UserEntity, UserRepository>
        implements UserService {

    private final RoleService roleRepository;
    private final PasswordEncoder encoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleService roleRepository, PasswordEncoder encoder) {
        super(userRepository);
        this.roleRepository = roleRepository;
        this.encoder = encoder;
    }

    @Override
    public void save(UserEntity entity) {
        RoleEntity userRole = roleRepository.findByName("ROLE_USER");
        entity.setRole(userRole);
        entity.setPassword(encoder.encode(entity.getPassword()));
        super.repository.save(entity);
    }

    public UserEntity findByLoginAndPassword(String username, String password) {
        UserEntity userEntity = super.repository.findByUsername(username);
        if (userEntity != null) {
            if (encoder.matches(password, userEntity.getPassword())) {
                return userEntity;
            }
        }
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return super.repository.findByUsername(s);
    }
}
