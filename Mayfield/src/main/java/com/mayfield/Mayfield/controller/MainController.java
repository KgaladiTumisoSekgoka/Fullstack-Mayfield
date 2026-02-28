package com.mayfield.Mayfield.controller;

import org.springframework.ui.Model;
import com.mayfield.Mayfield.model.ClothingItem;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.Authentication;

import java.util.ArrayList;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(Authentication authentication, Model model) {
        if (authentication != null && authentication.isAuthenticated()) {
            model.addAttribute("user_name", authentication.getName());
        } else {
            model.addAttribute("user_name", "Guest");
        }

        model.addAttribute("featuredItems", getFeaturedItems());
        return "index";
    }

    private List<ClothingItem> getFeaturedItems() {
        return new ArrayList<>();
    }
}