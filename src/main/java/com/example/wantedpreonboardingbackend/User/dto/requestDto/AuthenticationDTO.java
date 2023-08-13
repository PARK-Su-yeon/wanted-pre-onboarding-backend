package com.example.wantedpreonboardingbackend.User.dto.requestDto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AuthenticationDTO {

    @Pattern(regexp =  ".*@.*")
    private String email;
    @Size(min = 8)
    private String password;


}
