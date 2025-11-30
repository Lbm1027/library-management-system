package com.example.demo.controller;

import com.example.demo.domain.books;
import com.example.demo.service.booksService;
import com.example.demo.domain.VO.BooksCategoriesVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("/books")
public class booksController {

    @Autowired
    private booksService booksService;

    @GetMapping
    public String getAllBooks(Model model) {
        List<BooksCategoriesVO> books = booksService.getAllBooksWithCategories();
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/search")
    public String searchBooksByCategoryId(@RequestParam("categoryID") int categoryID, Model model) {
        List<BooksCategoriesVO> books = booksService.getBooksByCategoryId(categoryID);
        model.addAttribute("books", books);
        return "books";
    }

    @PostMapping("/add")
    public String insertBook(@RequestParam String title,
                          @RequestParam String author,
                          @RequestParam Date publishedDate,
                          @RequestParam String isbn,
                          @RequestParam int categoryID,
                          @RequestParam int availableCopies) {
        books book = new books();
        book.setTitle(title);
        book.setAuthor(author);
        book.setPublishedDate(publishedDate);
        book.setIsbn(isbn);
        book.setCategoryID(categoryID);
        book.setAvailableCopies(availableCopies);
        booksService.insertBook(book);
        return "redirect:/books";
    }

    @GetMapping("/add")
    public String insertBook() {
        return "/addBook";
    }
}

