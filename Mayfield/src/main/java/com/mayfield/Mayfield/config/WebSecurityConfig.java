package com.mayfield.Mayfield.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        // Static resources (CSS, JS, images)
                        .requestMatchers("/css/**", "/css_assets/**", "/js/**", "/javascript_assets/**",
                                "/images/**", "/_images/**", "/webjars/**","/dashboard/**").permitAll()

                        // Public pages - anyone can view
                        .requestMatchers("/", "/index", "/catalog", "/about_us", "/contact_us",
                                "/search_result", "/selected_item", "/item/**").permitAll()

                        // Authentication pages - must be accessible to anonymous users
                        .requestMatchers("/login","/mayfield", "/api/auth/**" ,"/register", "/signup", "/forgot-password").permitAll()

                        // Protected pages - login required
                        .requestMatchers("/cart", "/checkout", "/account/**", "/orders/**", "/profile", "/settings").authenticated()

                        // Admin only
                        .requestMatchers("/admin/**").hasRole("ADMIN")

                        // Everything else requires login
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/mayfield")
                        .loginProcessingUrl("/api/auth/login")
                        .usernameParameter("email")
                        .passwordParameter("password")
                        .defaultSuccessUrl("/", false)  // Go to requested page or home
                        .failureUrl("/mayfield?error=true")
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/mayfield")
                        .permitAll()
                )
                .csrf(csrf -> csrf.disable());


        return http.build();
    }
}