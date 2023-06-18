package com.kalgooksoo.service;

import com.kalgooksoo.criteria.CategoryCriteria;
import com.kalgooksoo.mapper.CategoryMapper;
import com.kalgooksoo.model.Category;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
public class CategoryService {

    private final CategoryMapper categoryMapper;

    public CategoryService(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    public Collection<Category> findAll() {
        return this.categoryMapper.findAll();
    }

    public Collection<Category> findByPage(CategoryCriteria criteria) {
        // TODO 정렬 처리할 것
        return this.categoryMapper.findByPage(criteria);
    }

    public Category findById(Long id) {
        return this.categoryMapper.findById(id);
    }

    public void insert(Category category) {
        this.categoryMapper.insert(category);
    }

}
