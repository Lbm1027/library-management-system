package com.example.demo.controller;

import com.example.demo.domain.categories;
import com.example.demo.service.categoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class categoriesController {

    @Autowired
    private categoriesService categoriesService;

    @GetMapping
    public String categoriesHome(Model model) {
        List<categories> categoriesList = categoriesService.getAllCategories();
        model.addAttribute("categories", categoriesList);
        return "categories";
    }

    @PostMapping("/add")
    public String addCategory(@RequestParam("categoryName") String categoryName, Model model) {
        if (categoryName == null || categoryName.trim().isEmpty()) {
            model.addAttribute("errorMessage", "Category name cannot be empty.");
            return "categoryAddError";
        }
        categories category = new categories();
        category.setCategoryName(categoryName);
        categoriesService.insertCategory(category);
        return "redirect:/categories";
    }

    @PostMapping("/delete")
    public String deleteCategory(@RequestParam("categoryID") int categoryID, Model model) {
        categoriesService.deleteCategory(categoryID);
        return "redirect:/categories";
    }
}

