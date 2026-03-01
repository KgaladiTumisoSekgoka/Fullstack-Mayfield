# Mayfield · Clothing Marketplace

> A Spring Boot powered e-commerce platform for pre-loved fashion.  
> *Sponsored by Spring Boot* ☕

---

## Overview

Mayfield is a full-stack web application connecting buyers and sellers of quality second-hand clothing. Built with Spring Boot, Thymeleaf, and modern web technologies.

---

## Tech Stack

| Layer | Technology |
|-------|-----------|
| Backend | Spring Boot 3.x |
| Security | Spring Security |
| Template Engine | Thymeleaf |
| Database | MySQL |
| Frontend | HTML5, CSS3, JavaScript |
| Build Tool | Maven |

---

## Quick Start

### Prerequisites
- Java 17+
- MySQL 8.0+
- Maven 3.8+

### 1. Database Setup

```sql
CREATE SCHEMA mayfield;
USE mayfield;

CREATE TABLE users(
    id INT AUTO_INCREMENT NOT NULL,
    fullname VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE,
    password CHAR(120) NOT NULL,
    enabled BOOLEAN DEFAULT TRUE,
    PRIMARY KEY(id)
);
```md
---
## 2. Configuration
Create src/main/resources/application.properties:

# Database
spring.datasource.url=jdbc:mysql://localhost:3306/mayfield
spring.datasource.username=your_username
spring.datasource.password=your_password

# JPA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# Server
server.port=8080
---


## 3. Run Application

mvn spring-boot:run
Or run MayfieldApplication.java from your IDE.

# Developer Testing Guide
Public Routes (No Login Required)

## URL	Description
http://localhost:8080/	Home page with featured items
http://localhost:8080/catalog	Browse all products
http://localhost:8080/about_us	About Mayfield
http://localhost:8080/contact_us	Contact page
http://localhost:8080/search_result?query=shirt	Search results

Custom Auth Pages (For UI Testing)

URL	Description	Notes
http://localhost:8080/mayfield	Custom login/signup page	Wine-red themed dual-form design

Test Credentials (if using in-memory):
Email: user@example.com
Password: password
Admin Dashboard

URL	Description	Access
http://localhost:8080/dashboard	Main dashboard	Public (for demo)
http://localhost:8080/dashboard/charts	Analytics charts	Public
http://localhost:8080/dashboard/tables	Data tables	Public
http://localhost:8080/dashboard/401	Error 401 page	Public
http://localhost:8080/dashboard/404	Error 404 page	Public
http://localhost:8080/dashboard/500	Error 500 page	Public

---
## Project Structure

src/main/
├── java/com/mayfield/Mayfield/
│   ├── config/
│   │   └── WebSecurityConfig.java    # Security rules
│   ├── controller/
│   │   ├── MainController.java       # Home, catalog, public pages
│   │   ├── AuthController.java       # Login/logout routes
│   │   ├── AuthApiController.java    # AJAX auth endpoints
│   │   ├── DashboardController.java  # Admin dashboard
│   │   └── UserController.java       # User CRUD
│   ├── model/
│   │   ├── User.java                 # User entity
│   │   └── ClothingItem.java         # Product entity
│   ├── repository/
│   │   └── UserRepository.java       # Data access
│   └── service/
│       └── UserService.java          # Business logic
│
└── resources/
    ├── templates/
    │   ├── index.html                  # Home page
    │   ├── catalog.html                # Product listing
    │   ├── mayfield.html               # Custom login/signup
    │   ├── dashboard/                  # Admin panel
    │   │   ├── index.html
    │   │   ├── charts.html
    │   │   ├── tables.html
    │   │   └── 401.html, 404.html, 500.html
    │   └── fragments/                  # Reusable components
    │
    └── static/
        ├── css_assets/               # Main site styles
        ├── javascript_assets/        # Main site scripts
        ├── _images/                  # Product images
        └── dashboard/                # Admin assets
            ├── css/
            ├── js/
            └── assets/

## Credits
- **Framework:** Spring Boot
- **UI Template:** SB Admin 2 (Dashboard)
- **Custom Auth UI:** Mayfield Design Team
- **Database:** MySQL
##License
- Internal use only · Mayfield 2025
