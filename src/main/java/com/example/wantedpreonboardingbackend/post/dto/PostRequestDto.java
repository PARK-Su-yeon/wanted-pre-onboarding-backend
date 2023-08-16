package com.example.wantedpreonboardingbackend.post.dto;

import jakarta.persistence.Column;
import lombok.Getter;

@Getter
public class PostRequestDto {

    private String title;
    private String content;
}
