package com.acem.demo.repository;

import com.acem.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String emailAddress);
}
