package com.example.demo.service.impl;

import com.example.demo.domain.categories;
import com.example.demo.mapper.categoriesMapper;
import com.example.demo.service.categoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class categoriesServiceImpl implements categoriesService {

    @Autowired
    private categoriesMapper categoriesMapper;

    @Override
    public List<categories> getAllCategories() {
        return categoriesMapper.getAllCategories();
    }

    @Override
    public void insertCategory(categories category) {
        categoriesMapper.insertCategory(category);
    }

    @Override
    public void deleteCategory(int categoryID) {
        categoriesMapper.deleteCategory(categoryID);
    }
}
