package com.example.demo.service;

import com.example.demo.domain.categories;

import java.util.List;

public interface categoriesService {
    List<categories> getAllCategories();
    void insertCategory(categories category);
    void deleteCategory(int categoryID);
    boolean categoryExists(int categoryID);
}
