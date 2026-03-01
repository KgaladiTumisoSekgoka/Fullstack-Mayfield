package com.mayfield.Mayfield.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String login() {
        return "redirect:/mayfield";  // Redirect old /login to new page
    }

    @GetMapping("/mayfield")
    public String mayfield(@RequestParam(value = "error", required = false) String error,
                           @RequestParam(value = "logout", required = false) String logout,
                           Model model) {

        if (error != null) {
            model.addAttribute("errorMsg", "Invalid email or password");
        }
        if (logout != null) {
            model.addAttribute("msg", "Logged out successfully");
        }

        return "mayfield";  // Renders templates/mayfield.html
    }

    @GetMapping("/register")
    public String register() {
        return "redirect:/mayfield";  // Both on same page
    }
}