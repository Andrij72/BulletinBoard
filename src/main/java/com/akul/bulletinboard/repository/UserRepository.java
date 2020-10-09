package com.akul.bulletinboard.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akul.bulletinboard.model.User;

    @Repository
    public interface UserRepository extends JpaRepository<User, Long>{
        User findUserByEmail(String email);
        User findByLastName(String lastName);
        User existsUserByEmail(String email);
    }