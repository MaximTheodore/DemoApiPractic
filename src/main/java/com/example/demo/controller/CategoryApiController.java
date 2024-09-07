package com.example.demo.controller;

import com.example.demo.model.CategoryModel;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/goods/category")
public class CategoryApiController {
    @Autowired
    private final CategoryService categoryService;

    public CategoryApiController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<CategoryModel> getAllCategories() {
        return categoryService.findAllCategories();
    }

    @PostMapping
    public CategoryModel createCategory(@RequestBody CategoryModel categoryModel) {
        return categoryService.createCategory(categoryModel);
    }

    @DeleteMapping
    public void deleteCategory(@RequestBody CategoryModel categoryModel) {
        categoryService.deleteCategory(categoryModel.getId());
    }
}
