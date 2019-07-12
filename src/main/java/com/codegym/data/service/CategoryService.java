package com.codegym.data.service;

import com.codegym.data.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {

        Page<Category> findAll(Pageable pageable);

        Category findById(Long Id);

        void save(Category category);

        void remove(Long Id);
}
