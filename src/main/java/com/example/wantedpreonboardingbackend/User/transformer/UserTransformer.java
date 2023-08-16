package com.example.wantedpreonboardingbackend.User.transformer;


import com.example.wantedpreonboardingbackend.User.dto.requestDto.SignupDTO;
import com.example.wantedpreonboardingbackend.User.dto.responseDto.UserDTO;
import com.example.wantedpreonboardingbackend.User.entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserTransformer {
    public static User signUpDtoToUser(SignupDTO signupDTO){
        return User.builder()
                .email(signupDTO.getEmail())
                .password(new BCryptPasswordEncoder().encode(signupDTO.getPassword()))
                .build();
    }

    public static UserDTO userToUserDto(User user){
        return UserDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .build();
    }
}
