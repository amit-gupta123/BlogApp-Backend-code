package com.amit.blogapp.repositories;

import com.amit.blogapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    // this can be empty, we will use methods provided by JPA Repository
    // no need to create its implementation
}
