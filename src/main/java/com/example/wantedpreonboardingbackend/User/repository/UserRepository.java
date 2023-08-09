package com.example.wantedpreonboardingbackend.User.repository;

import com.example.wantedpreonboardingbackend.User.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findFirstByEmail(String email);

    Optional<User> findByEmail(String email);
}
