package com.example.demo.service.impl;

import com.example.demo.domain.books;
import com.example.demo.mapper.booksMapper;
import com.example.demo.service.booksService;
import com.example.demo.domain.VO.BooksCategoriesVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class booksServiceImpl implements booksService {

    @Autowired
    private booksMapper booksMapper;

    @Override
    public List<books> getAllBooks() {
        return booksMapper.getAllBooks();
    }

    @Override
    public List<BooksCategoriesVO> getBooksByCategoryId(int categoryID) {
        return booksMapper.getBooksByCategoryId(categoryID);
    }

    @Override
    public List<BooksCategoriesVO> getAllBooksWithCategories() {
        return booksMapper.getAllBooksWithCategories();
    }

    @Override
    public books getBookById(int bookId) {
        return booksMapper.getBookById(bookId);
    }

    @Override
    public books getBookByTitle(String title) {
        return booksMapper.getBookByTitle(title);
    }

    @Override
    @Transactional
    public void insertBook(books book) {
        // Insert books to database
        booksMapper.insertBook(book);
    }


    @Override
    public void updateBook(books book) {
        booksMapper.updateBook(book);
    }

    @Override
    public void deleteBook(int bookID) {
        booksMapper.deleteBook(bookID);
    }

    @Override
    public int countBooksByCategoryId(int categoryID) {
        return booksMapper.countBooksByCategoryId(categoryID);
    }
}
