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
    public String getBorrowRecordsByUserId(@RequestParam("userID") int userID, Model model) {
        List<borrowRecords> borrowRecords = borrowRecordsService.getBorrowRecordsByUserId(userID);
        model.addAttribute("borrowRecords", borrowRecords);
        return "borrowRecords";
    }
}

