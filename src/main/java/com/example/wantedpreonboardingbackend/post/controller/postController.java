package com.example.wantedpreonboardingbackend.post.controller;

import com.example.wantedpreonboardingbackend.global.response.ResultResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class postController {

    @GetMapping("/api/v1/ji/paradise")
    public String paradise(){
        return "paradise";
    }
}
