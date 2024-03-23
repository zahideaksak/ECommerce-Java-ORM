package com.tobeto.pairwork_orm.controllers;

import com.tobeto.pairwork_orm.entities.Category;
import com.tobeto.pairwork_orm.repositories.CategoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {
    private CategoryRepository categoryRepository;

    public CategoriesController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @PostMapping
    public String add(@RequestBody Category category) {
        categoryRepository.save(category);
        return "Başarıyla eklendi.";
    }

    @PutMapping
    public String update(@RequestBody Category category) {
        categoryRepository.save(category);
        return "Başarıyla güncellendi";
    }

    @DeleteMapping
    public String delete(@RequestParam int categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new RuntimeException("Category bulunamadı"));
        categoryRepository.delete(category);
        return "Başarıyla silindi.";
    }
}
