package com.codegym.data.repository;

import com.codegym.data.model.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.concurrent.atomic.LongAccumulator;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {
}
