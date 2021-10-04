package com.helovei.donorApi.service.impl;

import com.helovei.donorApi.model.RoleEntity;
import com.helovei.donorApi.model.UserEntity;
import com.helovei.donorApi.repository.RoleRepository;
import com.helovei.donorApi.repository.UserRepository;
import com.helovei.donorApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserEntity loadUserByUsername(String s) throws UsernameNotFoundException {
        UserEntity user = userRepository.findUserByUsername(s);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        } else return user;
    }

    @Override
    public Iterable<UserEntity> getAll() {
        return userRepository.findAll();
    }

    public UserEntity findUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public boolean save(UserEntity user) {
        UserEntity foundUser = userRepository.findUserByUsername(user.getUsername());
        if (foundUser != null) {
            return false;
        } else {
            RoleEntity userRole = roleRepository.findRoleEntityByName("ROLE_USER");
            user.setRoles(Collections.singleton(userRole));
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
        }
        ;
        return true;
    }

    @Override
    public UserEntity findUserByUsernameAndPassword(String username, String password) {
        UserEntity foundUser = this.userRepository.findUserByUsername(username);
        return matchUser(foundUser,password) ? foundUser : null;
    }

    private boolean matchUser(UserEntity foundUser, String password){
        if(foundUser != null){
            if (passwordEncoder.matches(password, foundUser.getPassword())){
                return true;
            } else return false;
        } else return false;
    }
}
