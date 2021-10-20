package com.helovei.donorApi.controller;

import com.helovei.donorApi.dto.AuthRequest;
import com.helovei.donorApi.dto.AuthResponse;
import com.helovei.donorApi.dto.RegRequest;
import com.helovei.donorApi.model.UserEntity;
import com.helovei.donorApi.security.JwtProvider;
import com.helovei.donorApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final UserService userService;
    private final JwtProvider jwtProvider;

    @Autowired
    public AuthController(UserService userService, JwtProvider jwtProvider) {
        this.userService = userService;
        this.jwtProvider = jwtProvider;
    }

    @PostMapping("/auth")
    public Object getToken(@RequestBody AuthRequest request) {
        if (userService.findByLoginAndPassword(request.getUsername(), request.getPassword()) != null) {
            return new AuthResponse(jwtProvider.generateToken(request.getUsername()));
        }
        return HttpStatus.BAD_REQUEST;
    }

    @PostMapping("/reg")
    public Object registration(@Validated @RequestBody RegRequest request) {
        if (request != null) {
            UserEntity newUser = new UserEntity();
            newUser.setUsername(request.getUsername());
            newUser.setPassword(request.getPassword());
            newUser.setEmail(request.getEmail());
            userService.save(newUser);
            return HttpStatus.OK;
        }
        return HttpStatus.BAD_REQUEST;
    }

    @GetMapping("/test_token")
    public Object testToken() {
        return HttpStatus.OK;
    }
}
