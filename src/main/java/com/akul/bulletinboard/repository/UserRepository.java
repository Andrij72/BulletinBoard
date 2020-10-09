package com.akul.bulletinboard.repository;


import com.akul.bulletinboard.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface UserRepository extends JpaRepository<User, Long>{
        User findUserByEmail(String email);
        User findByLastName(String lastName);
        User existsUserByEmail(String email);
    }