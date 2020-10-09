package com.akul.bulletinboard.controllers;

import com.akul.bulletinboard.model.Post;
import com.akul.bulletinboard.model.Role;
import com.akul.bulletinboard.model.User;
import com.akul.bulletinboard.repository.UserRepository;
import com.akul.bulletinboard.service.PostService;
import com.akul.bulletinboard.service.UserService;
import com.akul.bulletinboard.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.Principal;
import java.time.LocalDate;
import java.util.Arrays;

@Controller
public class MainController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String home(Model model, HttpServletRequest request) {

        int postsPageNumber = 0;
        int quantityPostOnPage = 10;


        if (request.getParameter("page") != null && !request.getParameter("page").isEmpty()) {
            postsPageNumber = Integer.parseInt(request.getParameter("page")) - 1;
        }

        if (request.getParameter("size") != null && !request.getParameter("size").isEmpty()) {
            quantityPostOnPage = Integer.parseInt(request.getParameter("size"));
        }

        model.addAttribute("page", postService.findAll(PageRequest.of(postsPageNumber, quantityPostOnPage)));
        return "index";
    }

    @GetMapping("profile")
    public String showCabinetForm() {
        return "cabinet";
    }

    @PostMapping("profile")
    public String EditUserAccount(@ModelAttribute("user") UserRegistrationDto user, Principal principal) {
        User userFromDb = userService.findUserByEmail(principal.getName());
       User upd_user = new User(userFromDb.getId(),  user.getFirstName(), user.getLastName(), user.getEmail(),
               user.getPassword(), userFromDb.getRoles());
       userRepository.save(upd_user);
        return "cabinet";
    }

    @GetMapping("/cabinet")
    public String showCabinet(Principal principal, Model model) {
        User user = userService.findUserByEmail(principal.getName());
        model.addAttribute("user", user);
        return "cabinet";
    }

    @PostMapping("/cabinet")
    public String addPost(Principal principal,
                          @RequestParam MultipartFile filename,
                          @RequestParam String title, @RequestParam String anons, @RequestParam String full_text,
                          Model model) throws IOException {
        String authUserName = principal.getName();
        User user = userService.findUserByEmail(authUserName);
        Post post = new Post(title, filename.getBytes(), full_text, anons, LocalDate.now(), user);
        postService.save(post);
        return "cabinet";
    }

}
