package com.example.wantedpreonboardingbackend.post.controller;

import com.example.wantedpreonboardingbackend.global.response.ResultResponse;
import com.example.wantedpreonboardingbackend.post.dto.PostRequestDto;
import com.example.wantedpreonboardingbackend.post.entity.CustomPrincipal;
import com.example.wantedpreonboardingbackend.post.entity.Post;
import com.example.wantedpreonboardingbackend.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RequestMapping("/api/v1/")
@RestController
public class postController {

    @Autowired
    PostService postservice;

    @PostMapping("/posts") // Principal principal  @AuthenticationPrincipal CustomPrincipal principal
    public ResponseEntity<?> posting(@RequestBody PostRequestDto dto, Principal principal) {
        String email=principal.getName();
        return ResponseEntity.ok(postservice.createPost(dto, email));

    }
}
