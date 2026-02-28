package com.mayfield.Mayfield.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    // Main dashboard home
    @GetMapping("/dashboard/401")
    public String FourOnePage() {
        return "dashboard/401"; // dashboard/401.html
    }
    @GetMapping("/dashboard/404")
    public String FourErrorPage() {
        return "dashboard/404"; // dashboard/404.html
    }
    @GetMapping("/dashboard/500")
    public String FiveErrorPage() {
        return "dashboard/500"; // dashboard/404.html
    }
    @GetMapping("/dashboard/charts")
    public String analyticsPage() {
        return "dashboard/charts"; // dashboard/analytics.html
    }
    @GetMapping("/dashboard")
    public String dashboardHome() {
        return "dashboard/index"; // Looks for src/main/resources/templates/dashboard/index.html
    }
    // Analytics page
    @GetMapping("/dashboard/tables")
    public String TablePage() {
        return "dashboard/tables"; // dashboard/tables.html
    }
}