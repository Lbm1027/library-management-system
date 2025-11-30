package com.example.demo.mapper;

import com.example.demo.domain.categories;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface categoriesMapper {
    List<categories> getAllCategories();
    void insertCategory(categories category);
    void deleteCategory(int categoryID);
}
