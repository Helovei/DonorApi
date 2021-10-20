package com.helovei.donorApi.service.impl;

import com.helovei.donorApi.model.RoleEntity;
import com.helovei.donorApi.model.UserEntity;
import com.helovei.donorApi.repository.RoleRepository;
import com.helovei.donorApi.repository.UserRepository;
import com.helovei.donorApi.service.RoleService;
import com.helovei.donorApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleService roleRepository;
    private final PasswordEncoder encoder;

    private String secureWord;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleService roleRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
    }

    @Override
    public void save(UserEntity entity) {
        RoleEntity userRole = roleRepository.findByName("ROLE_USER");
        entity.setRole(userRole);
        entity.setPassword(encoder.encode(entity.getPassword()));
        userRepository.save(entity);
    }

    @Override
    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void delete(UserEntity entity) {
        userRepository.delete(entity);
    }

    public UserEntity findByLoginAndPassword(String username, String password) {
        UserEntity userEntity = userRepository.findByUsername(username);
        if (userEntity != null) {
            if (encoder.matches(password, userEntity.getPassword())) {
                return userEntity;
            }
        }
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByUsername(s);
    }
}
