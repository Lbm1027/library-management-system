package com.example.demo.mapper;

import com.example.demo.domain.books;
import com.example.demo.domain.VO.BooksCategoriesVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface booksMapper {
    books getBookById(int bookID);
    List<books> getAllBooks();
    List<BooksCategoriesVO> getBooksByCategoryName(String categoryName);
    books getBookByTitle(String title);
    void insertBook(books book);
    void updateBook(books book);
    void deleteBook(int bookID);
    int countBooksByCategoryId(int categoryID);
    List<BooksCategoriesVO> getAllBooksWithCategories();
}
