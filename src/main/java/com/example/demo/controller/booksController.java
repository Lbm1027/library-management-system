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
                          @RequestParam String categoryID,
                          @RequestParam String availableCopies,
                          Model model) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate parsedDate;
        try {
            parsedDate = LocalDate.parse(publishedDateString, formatter);
        } catch (DateTimeParseException e) {
            model.addAttribute("errorMessage", "Invalid date format. Please use yyyy/MM/dd.");
            return "bookAddError";
        }

        int parsedCategoryId;
        try {
            parsedCategoryId = Integer.parseInt(categoryID);
        } catch (NumberFormatException e) {
            model.addAttribute("errorMessage", "Category ID must be a valid number.");
            return "bookAddError";
        }

        if (!categoriesService.categoryExists(parsedCategoryId)) {
            model.addAttribute("errorMessage", "No such category ID. Please choose an existing category.");
            return "bookAddError";
        }

        int parsedAvailableCopies;
        try {
            parsedAvailableCopies = Integer.parseInt(availableCopies);
        } catch (NumberFormatException e) {
            model.addAttribute("errorMessage", "Available copies must be a valid number.");
            return "bookAddError";
        }

        if (parsedAvailableCopies < 0) {
            model.addAttribute("errorMessage", "Available copies cannot be negative.");
            return "bookAddError";
        }
        books book = new books();
        book.setTitle(title);
        book.setAuthor(author);
        book.setPublishedDate(Date.valueOf(parsedDate));
        book.setIsbn(isbn);
        book.setCategoryID(parsedCategoryId);
        book.setAvailableCopies(parsedAvailableCopies);
        booksService.insertBook(book);
        return "redirect:/books";
    }

    @GetMapping("/add")
    public String insertBook() {
        return "addBook";
    }
}

