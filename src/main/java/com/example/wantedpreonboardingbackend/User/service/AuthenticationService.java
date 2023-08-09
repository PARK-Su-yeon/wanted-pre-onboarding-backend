package com.example.wantedpreonboardingbackend.User.service;


import com.example.wantedpreonboardingbackend.User.dto.requestDto.AuthenticationDTO;
import com.example.wantedpreonboardingbackend.User.dto.responseDto.AuthenticationResponseDTO;
import com.example.wantedpreonboardingbackend.User.exception.UserIsDisabledException;
import com.example.wantedpreonboardingbackend.User.exception.WrongCredintialsException;

public interface AuthenticationService {
    public AuthenticationResponseDTO createJWTToken(AuthenticationDTO authenticationDTO) throws WrongCredintialsException, UserIsDisabledException;
}
