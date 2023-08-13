package com.example.wantedpreonboardingbackend.post.repository;

import com.example.wantedpreonboardingbackend.User.model.User;
import com.example.wantedpreonboardingbackend.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

}