package com.codegym.data.service;

import com.codegym.data.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    Page<Blog> findAll(Pageable pageable);

    Blog findById(Long Id);

    void save(Blog blog);

    void remove(Long Id);
}
