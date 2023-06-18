package com.kalgooksoo.controller;

import com.kalgooksoo.criteria.CategoryCriteria;
import com.kalgooksoo.model.Category;
import com.kalgooksoo.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<Collection<Category>> findAll(CategoryCriteria criteria) {
        return ResponseEntity.ok(this.categoryService.findByPage(criteria));
    }

    @GetMapping("{id}")
    public ResponseEntity<Category> find(@PathVariable Long id) {
        return ResponseEntity.ok(this.categoryService.findById(id));
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Category category) {
        this.categoryService.insert(category);
        return ResponseEntity.ok("ok");
    }

    @PostMapping("/init")
    public ResponseEntity<String> init() {
        for (int i = 0; i < 100; i++) {
            this.save(new Category("name"));
        }
        return ResponseEntity.ok("ok");
    }

}
