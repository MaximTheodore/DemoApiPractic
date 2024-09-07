package com.example.demo.controller;

import com.example.demo.model.CategoryModel;
import com.example.demo.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public String getAllCategories(Model model) {
        List<CategoryModel> categories = categoryService.findAllCategories();
        model.addAttribute("categories", categories);
        model.addAttribute("category", new CategoryModel());
        return "CategoryList";
    }

    @PostMapping("/categories")
    public String createCategory(@Valid @ModelAttribute CategoryModel category, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<CategoryModel> categoryModels = categoryService.findAllCategories();
            model.addAttribute("category", category);
            model.addAttribute("categories", categoryModels);
            return "CategoryList";
        }
        categoryService.createCategory(category);
        return "redirect:/categories";
    }

    @GetMapping("/categories/edit/{id}")
    public String editCategory(@PathVariable Long id, Model model) {
        CategoryModel category = categoryService.findCategoryById(id);
        model.addAttribute("category", category);
        return "editCategory";
    }

    @PostMapping("/categories/update")
    public String updateCategory(@Valid @ModelAttribute CategoryModel category, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<CategoryModel> categoryModels = categoryService.findAllCategories();
            model.addAttribute("category", category);
            model.addAttribute("categories", categoryModels);
            return "CategoryList";
        }
        categoryService.updateCategory(category);
        return "redirect:/categories";
    }

    @GetMapping("/categories/delete/{id}")
    public String deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return "redirect:/categories";
    }


}
