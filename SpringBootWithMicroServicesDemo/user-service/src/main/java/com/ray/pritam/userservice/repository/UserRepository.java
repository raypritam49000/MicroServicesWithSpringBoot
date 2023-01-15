package com.ray.pritam.userservice.repository;

import com.ray.pritam.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface UserRepository extends JpaRepository<User,Long> {
    public User findByUsername(String username);
}
