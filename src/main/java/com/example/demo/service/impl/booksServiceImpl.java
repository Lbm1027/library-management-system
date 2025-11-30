package com.example.demo.service.impl;

import com.example.demo.domain.books;
import com.example.demo.mapper.booksMapper;
import com.example.demo.service.booksService;
import com.example.demo.domain.VO.BooksCategoriesVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class booksServiceImpl implements booksService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private booksMapper booksMapper;

    @Override
    public List<books> getAllBooks() {
        String key = "books_all";

        //Redis implements on retrieving books
        List<books> books = (List<books>) redisTemplate.opsForValue().get(key);
        if (books == null) {
            books = booksMapper.getAllBooks();
            redisTemplate.opsForValue().set(key, books);
        }
        return books;
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
        String key = "book_" + bookId;

        //Redis implements on searching books
        books book = (books) redisTemplate.opsForValue().get(key);
        if (book == null) {
            book = booksMapper.getBookById(bookId);
            redisTemplate.opsForValue().set(key, book);
        }
        return book;
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
            // Update Redis caches
            redisTemplate.opsForValue().set("book_" + book.getBookID(), book);
            // Update all book list caches
            redisTemplate.delete("books_all");
            redisTemplate.opsForValue().set("books_all", booksMapper.getAllBooks());
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
