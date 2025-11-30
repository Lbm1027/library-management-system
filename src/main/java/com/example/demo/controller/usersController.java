package com.example.demo.controller;

import com.example.demo.domain.users;
import com.example.demo.service.usersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class usersController {

    @Autowired
    private usersService usersService;

    @GetMapping
    public String searchPage(Model model) {
        List<users> users = usersService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @PostMapping("/add")
    public String addUser(@RequestParam("name") String name,
                          @RequestParam("email") String email,
                          @RequestParam("phone") String phone,
                          @RequestParam("membershipType") String membershipType) {
        int nextUserId = usersService.getNextUserId();
        users newUser = new users();
        newUser.setUserID(nextUserId);
        newUser.setName(name);
        newUser.setEmail(email);
        newUser.setPhone(phone);
        newUser.setMembershipType(membershipType);
        usersService.insertUser(newUser);
        return "redirect:/users";
    }

    @GetMapping("/search")
    public String getUserByName(@RequestParam("name") String name, Model model) {
        List<users> users = usersService.getUsersByName(name);
        model.addAttribute("users", users);
        return "users";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("userID") int userID, Model model) {
        usersService.deleteUser(userID);
        return "redirect:/users";
    }

    @PostMapping("/update")
    public String updateUser(@RequestParam("userID") int userID, @RequestParam("membershipType") String membershipType, Model model) {
        usersService.updateMembershipType(userID, membershipType);
        return "redirect:/users";
    }
}
