package com.User.User.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.User.User.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

