package com.codegym.data.repository;

import com.codegym.data.model.Blog;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogRepository extends PagingAndSortingRepository<Blog,Long> {
}
