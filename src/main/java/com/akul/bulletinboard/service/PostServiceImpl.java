package com.akul.bulletinboard.service;

import com.akul.bulletinboard.model.Post;
import com.akul.bulletinboard.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class PostServiceImpl implements PostService {


    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
       super();
        this.postRepository = postRepository;
    }

    @Override
    public Page<Post> findAll(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    @Override
    public void save(Post post) {
        postRepository.save(post);
    }
}
