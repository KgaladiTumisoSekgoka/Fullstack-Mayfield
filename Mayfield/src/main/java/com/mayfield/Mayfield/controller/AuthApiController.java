package com.mayfield.Mayfield.controller;

import com.mayfield.Mayfield.model.User;
import com.mayfield.Mayfield.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthApiController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestParam String name,
                                         @RequestParam String email,
                                         @RequestParam String password) {
        try {
            // Check if email exists
            if (userService.findByEmail(email) != null) {
                return ResponseEntity.badRequest().body("❌ Email already registered");
            }

            User user = new User();
            user.setFullname(name);
            user.setEmail(email);
            user.setPassword(passwordEncoder.encode(password));
            user.setEnabled(true);

            userService.createUser(user);

            return ResponseEntity.ok("✅ Account created successfully!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("❌ Error: " + e.getMessage());
        }
    }
}