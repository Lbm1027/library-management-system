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
    public String getFinesByBorrowId(@RequestParam("borrowID") int borrowID, Model model) {
        List<fines> fines = finesService.getFinesByBorrowId(borrowID);
        model.addAttribute("fines", fines);
        return "fines";
    }

    @PostMapping("/add")
    public String addFine(@RequestParam("borrowID") int borrowID, @RequestParam("amount") int amount, Model model) {
        finesService.addFine(borrowID, amount);
        return "redirect:/fines";
    }
}
