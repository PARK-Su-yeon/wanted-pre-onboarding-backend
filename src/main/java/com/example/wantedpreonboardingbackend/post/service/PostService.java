package com.example.wantedpreonboardingbackend.post.service;

import com.example.wantedpreonboardingbackend.User.entity.User;
import com.example.wantedpreonboardingbackend.User.repository.UserRepository;
import com.example.wantedpreonboardingbackend.post.dto.PostMapper;
import com.example.wantedpreonboardingbackend.post.dto.PostRequestDto;
import com.example.wantedpreonboardingbackend.post.dto.PostResponseDto;
import com.example.wantedpreonboardingbackend.post.entity.Post;
import com.example.wantedpreonboardingbackend.post.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Transactional
@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;
    private final PostMapper postMapper;


    public Post  createPost(PostRequestDto dto,String email){
        User user=getUserIdFromUserDetails(email).orElseThrow(() -> new EntityNotFoundException("not found"));
        return postRepository.save(Post.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .user(user)
                .build());
    }

    private Optional <User> getUserIdFromUserDetails(String email) {
        return userRepository.findByEmail(email);

    }

    public List<PostResponseDto> pageList(Pageable pageable) {
        Page<Post> postList = postRepository.findAll(pageable);
        return postMapper.toDtoPageList(postList).getContent();
    }

    public Post getPost(Long id) {
            return postRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("not found"));
        }

    public Object update(Long id, PostRequestDto dto, String email) {

        Post entity= postRepository.findById(id).get();
        if (entity.getUser().getEmail().equals(email)) {
            entity.setTitle(dto.getTitle());
            entity.setContent(dto.getContent());
            return entity;
        }
        else
            return "업데이트실패";

    }


    public Object delete(Long id, String email) {
        Post entity = postRepository.findById(id).get();
        if (entity.getUser().getEmail().equals(email)) {
            if (postRepository.existsById(id)) {
                postRepository.deleteById(id);
                return "삭제  성공했습니다";

            }
        }
        return "삭제 실패";
    }
}
