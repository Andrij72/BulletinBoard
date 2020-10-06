package com.akul.bulletinboard.controllers;

import com.akul.bulletinboard.model.Post;
import com.akul.bulletinboard.model.User;
import com.akul.bulletinboard.repository.PostRepository;
import com.akul.bulletinboard.repository.UserRepository;
import com.akul.bulletinboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.Principal;
import java.time.LocalDate;
import java.util.Base64;

@Controller
public class MainController {


    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String home(Model model, HttpServletRequest request){

        int page = 0; //default page number is 0 (yes it is weird)
        int size = 2; //default page size is 10

        if (request.getParameter("page") != null && !request.getParameter("page").isEmpty()) {
            page = Integer.parseInt(request.getParameter("page")) - 1;
        }

        if (request.getParameter("size") != null && !request.getParameter("size").isEmpty()) {
            size = Integer.parseInt(request.getParameter("size"));
        }

        model.addAttribute("page", postRepository.findAll(PageRequest.of(page, size)));
        return "index";
    }

    @GetMapping("/cabinet")
    public String showCabinet(Principal principal, Model model) {

        User user = userRepository.findUserByEmail(principal.getName());
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
        postRepository.save(post);
        return "cabinet";
    }

    @PostMapping("profile")
    public String postEditProfile(Principal principal,
            @RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam String password,
            Model model) {
        User currentUser = userRepository.findUserByEmail(principal.getName());
            currentUser.setEmail(email);
        currentUser.setPassword(password);
        currentUser.setFirstName(firstName);
        currentUser.setLastName(lastName);
        userService.saveDB(currentUser);
        return "cabinet";
    }
}
