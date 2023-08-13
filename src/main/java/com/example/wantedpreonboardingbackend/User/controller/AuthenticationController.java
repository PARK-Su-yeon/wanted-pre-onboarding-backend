package com.example.wantedpreonboardingbackend.User.controller;

;
import com.example.wantedpreonboardingbackend.User.dto.requestDto.AuthenticationDTO;
import com.example.wantedpreonboardingbackend.User.dto.requestDto.SignupDTO;
import com.example.wantedpreonboardingbackend.User.dto.responseDto.AuthenticationResponseDTO;
import com.example.wantedpreonboardingbackend.User.dto.responseDto.UserDTO;
import com.example.wantedpreonboardingbackend.User.exception.UserAlreadyPresentException;
import com.example.wantedpreonboardingbackend.User.exception.UserIsDisabledException;
import com.example.wantedpreonboardingbackend.User.exception.WrongCredintialsException;
import com.example.wantedpreonboardingbackend.User.service.AuthService;
import com.example.wantedpreonboardingbackend.User.service.AuthenticationService;
import com.example.wantedpreonboardingbackend.global.response.ResponseCode;
import com.example.wantedpreonboardingbackend.global.response.ResultResponse;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RequestMapping("/api/v1")
@RestController
@RequiredArgsConstructor
public class AuthenticationController {
    @Autowired
    AuthenticationService authenticationService;


    @PostMapping("/authenticate")
    public ResponseEntity createAuthenticationToken(@RequestBody AuthenticationDTO authenticationDTO, HttpServletResponse response) throws IOException {
        try {
            AuthenticationResponseDTO authenticationResponseDTO = authenticationService.createJWTToken(authenticationDTO);
            return new ResponseEntity<>(authenticationResponseDTO, HttpStatus.CREATED);

        } catch (WrongCredintialsException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (UserIsDisabledException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (UsernameNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @Autowired
    private AuthService authService;

    @PostMapping("/sign-up")
    public ResponseEntity<?> signupUser(@Valid @RequestBody SignupDTO signupDTO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                String errorMessage = bindingResult.getFieldError().getDefaultMessage();
                return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
            }

            UserDTO createdUser = authService.createUser(signupDTO);
            return new ResponseEntity<>(createdUser, HttpStatus.CREATED);


        } catch (UserAlreadyPresentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
