package com.example.wantedpreonboardingbackend.User.repository;

import com.example.wantedpreonboardingbackend.User.entity.User;
import com.example.wantedpreonboardingbackend.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findFirstByEmail(String email);
    Optional<User> findByEmail(String email);


}
