package com.example.demo.controller;

import com.example.demo.domain.reservations;
import com.example.demo.service.reservationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reservations")
public class reservationsController {

    @Autowired
    private reservationsService reservationsService;

    @GetMapping
    public String searchPage() {
        return "reservations";
    }

    @GetMapping("/search")
    public String getReservationsByUserId(@RequestParam(value = "userID", required = false) String userID, Model model) {
        if (userID == null || userID.trim().isEmpty()) {
            model.addAttribute("errorMessage", "User ID is required to search reservations.");
            return "reservations";
        }
        try {
            int parsedUserId = Integer.parseInt(userID.trim());
            List<reservations> reservations = reservationsService.getReservationsByUserId(parsedUserId);
            model.addAttribute("reservations", reservations);
        } catch (NumberFormatException e) {
            model.addAttribute("errorMessage", "User ID must be a valid number.");
        }
        return "reservations";
    }
}
