package com.akul.bulletinboard.service;

import com.akul.bulletinboard.model.Post;
import com.akul.bulletinboard.repository.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;


@Service
public class PostServiceImpl implements PostService {
    private  PostRepository postRepository;


    @Override
    public Page<Post> findAll(Pageable pageable) {
        return postRepository.findAll((org.springframework.data.domain.Pageable) pageable);
    }

    @Override
    public void save(Post post) {

        postRepository.save(post);
    }
}
