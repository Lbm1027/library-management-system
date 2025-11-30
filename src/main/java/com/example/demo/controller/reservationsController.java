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
    public String getReservationsByUserId(@RequestParam("userID") int userID, Model model) {
        List<reservations> reservations = reservationsService.getReservationsByUserId(userID);
        model.addAttribute("reservations", reservations);
        return "reservations";
    }
}
