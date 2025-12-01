package com.example.demo.controller;

import com.example.demo.domain.borrowRecords;
import com.example.demo.service.borrowRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/borrowRecords")
public class borrowRecordsController {

    @Autowired
    private borrowRecordsService borrowRecordsService;

    @GetMapping
    public String searchPage() {
        return "borrowRecords";
    }

    @GetMapping("/search")
    public String getBorrowRecordsByUserId(@RequestParam(value = "userID", required = false) String userID, Model model) {
        if (userID == null || userID.trim().isEmpty()) {
            model.addAttribute("errorMessage", "User ID is required to search borrow records.");
            return "borrowRecords";
        }
        try {
            int parsedUserId = Integer.parseInt(userID.trim());
            List<borrowRecords> borrowRecords = borrowRecordsService.getBorrowRecordsByUserId(parsedUserId);
            model.addAttribute("borrowRecords", borrowRecords);
        } catch (NumberFormatException e) {
            model.addAttribute("errorMessage", "User ID must be a valid number.");
        }
        return "borrowRecords";
    }
}

