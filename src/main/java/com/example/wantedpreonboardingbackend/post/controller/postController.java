package com.example.wantedpreonboardingbackend.post.controller;

import com.example.wantedpreonboardingbackend.global.response.ResultResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/api/v1")
@RestController
public class postController {

    @PostMapping("/post")
    public String posting(){
        return "paradise";
    }
}
