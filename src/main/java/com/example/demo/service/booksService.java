package com.example.demo.service;

import com.example.demo.domain.books;
import com.example.demo.domain.VO.BooksCategoriesVO;

import java.util.List;

public interface booksService {
    List<books> getAllBooks();
    List<BooksCategoriesVO> getBooksByCategoryName(String categoryName);
    List<BooksCategoriesVO> getAllBooksWithCategories();
    books getBookById(int bookID);
    books getBookByTitle(String title);
    void insertBook(books book);
    void updateBook(books book);
    void deleteBook(int bookID);
    int countBooksByCategoryId(int categoryID);
}
