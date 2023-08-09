package com.example.wantedpreonboardingbackend.User.service;


import com.example.wantedpreonboardingbackend.User.dto.requestDto.SignupDTO;
import com.example.wantedpreonboardingbackend.User.dto.responseDto.UserDTO;
import com.example.wantedpreonboardingbackend.User.exception.UserAlreadyPresentException;

public interface AuthService {
    UserDTO createUser(SignupDTO signUpDto) throws UserAlreadyPresentException;
}
