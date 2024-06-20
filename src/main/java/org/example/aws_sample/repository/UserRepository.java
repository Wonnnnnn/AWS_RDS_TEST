package org.example.aws_sample.repository;

import org.example.aws_sample.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsById(String userid);
}
