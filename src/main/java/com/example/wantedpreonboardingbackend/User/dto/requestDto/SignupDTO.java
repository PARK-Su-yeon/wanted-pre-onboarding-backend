package com.example.wantedpreonboardingbackend.User.dto.requestDto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class SignupDTO {

    @Pattern(regexp =  ".*@.*",message="@포함 해야함")
    private String email;
    @Size(min = 8,message="크기 8 넘어야함 ")
    private String password;


}
