package com.example.wantedpreonboardingbackend.post.service;

import com.example.wantedpreonboardingbackend.User.entity.User;
import com.example.wantedpreonboardingbackend.User.repository.UserRepository;
import com.example.wantedpreonboardingbackend.post.dto.PostRequestDto;
import com.example.wantedpreonboardingbackend.post.entity.Post;
import com.example.wantedpreonboardingbackend.post.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class PostService {

    @Autowired
    private PostRepository postrepository;
    @Autowired
    private UserRepository userRepository;

    public Post  createPost(PostRequestDto dto,String email){
        User user=getUserIdFromUserDetails(email).orElseThrow(() -> new EntityNotFoundException("not found"));
        return postrepository.save(Post.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .user(user)
                .build());
    }

    private Optional <User> getUserIdFromUserDetails(String email) {
        return userRepository.findByEmail(email);

    }
}
