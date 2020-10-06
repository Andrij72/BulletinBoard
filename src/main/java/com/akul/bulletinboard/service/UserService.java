package com.akul.bulletinboard.service;


import com.akul.bulletinboard.model.Post;
import com.akul.bulletinboard.model.User;
import com.akul.bulletinboard.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);

    User findUsrById(Long id);

    User findUserByEmail(String email);

    List<User> findAll();

    User saveDB(User user);
}
