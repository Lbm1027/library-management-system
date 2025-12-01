package com.example.demo.controller;

import com.example.demo.domain.fines;
import com.example.demo.service.finesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/fines")
public class finesController {

    @Autowired
    private finesService finesService;

    @GetMapping
    public String searchPage() {
        return "fines";
    }

    @GetMapping("/search")
    public String getFinesByBorrowId(@RequestParam(value = "borrowID", required = false) String borrowID, Model model) {
        if (borrowID == null || borrowID.trim().isEmpty()) {
            model.addAttribute("errorMessage", "Borrow ID is required to search fines.");
            return "fines";
        }
        try {
            int parsedBorrowId = Integer.parseInt(borrowID.trim());
            List<fines> fines = finesService.getFinesByBorrowId(parsedBorrowId);
            model.addAttribute("fines", fines);
        } catch (NumberFormatException e) {
            model.addAttribute("errorMessage", "Borrow ID must be a valid number.");
        }
        return "fines";
    }

    @PostMapping("/add")
    public String addFine(@RequestParam("borrowID") int borrowID, @RequestParam("amount") int amount, Model model) {
        finesService.addFine(borrowID, amount);
        return "redirect:/fines";
    }
}
