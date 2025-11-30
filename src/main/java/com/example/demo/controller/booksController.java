package com.example.demo.controller;

import com.example.demo.domain.books;
import com.example.demo.service.booksService;
import com.example.demo.service.categoriesService;
import com.example.demo.domain.VO.BooksCategoriesVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Controller
@RequestMapping("/books")
public class booksController {

    @Autowired
    private booksService booksService;

    @Autowired
    private categoriesService categoriesService;

    @GetMapping
    public String getAllBooks(Model model) {
        List<BooksCategoriesVO> books = booksService.getAllBooksWithCategories();
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/search")
    public String searchBooksByCategoryName(@RequestParam("categoryName") String categoryName, Model model) {
        List<BooksCategoriesVO> books = booksService.getBooksByCategoryName(categoryName);
        model.addAttribute("books", books);
        return "books";
    }

    @PostMapping("/add")
    public String insertBook(@RequestParam String title,
                          @RequestParam String author,
                          @RequestParam("publishedDate") String publishedDateString,
                          @RequestParam String isbn,
                          @RequestParam int categoryID,
                          @RequestParam int availableCopies,
                          Model model) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate parsedDate;
        try {
            parsedDate = LocalDate.parse(publishedDateString, formatter);
        } catch (DateTimeParseException e) {
            model.addAttribute("errorMessage", "Invalid date format. Please use yyyy/MM/dd.");
            return "bookAddError";
        }

        if (!categoriesService.categoryExists(categoryID)) {
            model.addAttribute("errorMessage", "No such category ID. Please choose an existing category.");
            return "bookAddError";
        }
        books book = new books();
        book.setTitle(title);
        book.setAuthor(author);
        book.setPublishedDate(Date.valueOf(parsedDate));
        book.setIsbn(isbn);
        book.setCategoryID(categoryID);
        book.setAvailableCopies(availableCopies);
        booksService.insertBook(book);
        return "redirect:/books";
    }

    @GetMapping("/add")
    public String insertBook() {
        return "addBook";
    }
}

