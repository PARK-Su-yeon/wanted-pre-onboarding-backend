package com.example.wantedpreonboardingbackend.post.dto;

import com.example.wantedpreonboardingbackend.User.entity.User;
import com.example.wantedpreonboardingbackend.post.entity.Post;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostResponseDto {

    private Long PostId;
    private String title;
    private String content;




}

