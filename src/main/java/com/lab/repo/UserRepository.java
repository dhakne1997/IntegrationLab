package com.lab.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lab.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}

