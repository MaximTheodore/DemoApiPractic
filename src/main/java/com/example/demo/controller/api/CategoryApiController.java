package com.example.demo.controller.api;


import com.example.demo.model.CategoryModel;
import com.example.demo.model.CodeModel;
import com.example.demo.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/category")
public class CategoryApiController {


    private final CategoryService categoryService;

    public CategoryApiController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<CategoryModel> getAllCategories() {
        return categoryService.findAllCategories();
    }

    @GetMapping("/{id}")
    public CategoryModel getCategoryById(@PathVariable Long id) {
        return categoryService.findCategoryById(id);
    }

    @PostMapping
    public CategoryModel createCategory(@Valid @RequestBody CategoryModel category) {
        return categoryService.createCategory(category);
    }

    @PutMapping("/{id}")
    public CategoryModel updateCategory(@PathVariable Long id, @Valid @RequestBody CategoryModel category) {
        category.setId(id);
        return categoryService.updateCategory(category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }
}