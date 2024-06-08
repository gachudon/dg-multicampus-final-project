package com.dg.deukgeun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dg.deukgeun.dto.user.LoginDTO;
import com.dg.deukgeun.dto.user.ResponseDTO;
import com.dg.deukgeun.dto.user.UserSignUpDTO;
import com.dg.deukgeun.service.UserService;


@RestController
@RequestMapping("/api")

public class UserController {

    @Autowired UserService userService;
    
    //회원가입
    @PostMapping("/signUp")
    public ResponseDTO<?> signUp(@RequestBody UserSignUpDTO userSignUpDTO) {
        return userService.signUp(userSignUpDTO);
    }

    //로그인
    @PostMapping("/login")
    public ResponseDTO<?> login(@RequestBody LoginDTO loginDTO) {
        return userService.login(loginDTO);
    }

    @GetMapping("/userInfo")
    public ResponseDTO<?> getUserInfo(@RequestParam String email) {
        return userService.getUserInfo(email);
    }
}
