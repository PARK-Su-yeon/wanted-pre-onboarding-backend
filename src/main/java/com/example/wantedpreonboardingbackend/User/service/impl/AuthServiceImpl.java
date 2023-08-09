package com.example.wantedpreonboardingbackend.User.service.impl;


import com.example.wantedpreonboardingbackend.User.dto.requestDto.SignupDTO;
import com.example.wantedpreonboardingbackend.User.dto.responseDto.UserDTO;
import com.example.wantedpreonboardingbackend.User.exception.UserAlreadyPresentException;
import com.example.wantedpreonboardingbackend.User.model.User;
import com.example.wantedpreonboardingbackend.User.repository.UserRepository;
import com.example.wantedpreonboardingbackend.User.service.AuthService;
import com.example.wantedpreonboardingbackend.User.transformer.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDTO createUser(SignupDTO signupDTO) throws UserAlreadyPresentException {
        //check if user already present
        Optional<User> userOpt = userRepository.findByEmail(signupDTO.getEmail());
        if(userOpt.isPresent()){
            throw new UserAlreadyPresentException("User already present with this Email Id");
        }
        User user = UserTransformer.signUpDtoToUser(signupDTO);
        User createdUser = userRepository.save(user);
        UserDTO userDto = UserTransformer.userToUserDto(createdUser);
        return userDto;
//        User user = new User();
//        user.setName(signupDTO.getName());
//        user.setEmail(signupDTO.getEmail());
//        user.setPassword(new BCryptPasswordEncoder().encode(signupDTO.getPassword()));
//        User createdUser = userRepository.save(user);
//        UserDTO userDTO = new UserDTO();
//        userDTO.setId(createdUser.getId());
//        userDTO.setEmail(createdUser.getEmail());
//        userDTO.setName(createdUser.getName());
//        return userDTO;
    }

}
