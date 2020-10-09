package com.akul.bulletinboard.service;

import com.akul.bulletinboard.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface PostService {

    Page<Post> findAll(Pageable pageable);

    void save(Post post);
}
