package com.project.Cafe_Management_System.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy; // 1. Add Lazy import
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtUtil jwtUtil;
    private final UserDetailsService userDetailsService;

    // 2. Add @Lazy here to defer loading UserDetailsService until runtime
    public SecurityConfig(JwtUtil jwtUtil, @Lazy UserDetailsService userDetailsService) {
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        // Add both localhost (for development) and your deployed Vercel domain
        configuration.setAllowedOrigins(List.of(
                "http://localhost:5173",
                "https://cafe-management-system-fronted.vercel.app"
        ));

        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("Authorization", "Content-Type", "X-Requested-With", "Accept"));
        configuration.setExposedHeaders(List.of("Authorization"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        JwtFilter jwtFilter = new JwtFilter(jwtUtil, userDetailsService);

        http
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .csrf(csrf -> csrf.disable())
                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/login").permitAll()
                        .requestMatchers("/Customer/Post").permitAll()
                        .requestMatchers("/Token/Post").permitAll()
                        .requestMatchers("/User/**").permitAll()
                        .requestMatchers("/Roles/**").permitAll()
                        .requestMatchers("/Menu/Get").permitAll()
                        .requestMatchers("/Menu/Post").hasAnyRole("Admin", "Chef")
                        .requestMatchers("/Menu/Update").hasRole("Admin")
                        .requestMatchers("/Menu/Delete").hasRole("Admin")
                        .requestMatchers("/Inventory/Get").hasRole("Admin")
                        .requestMatchers("/Inventory/Post").hasRole("Admin")
                        .requestMatchers("/Inventory/Update").hasAnyRole("Admin", "Chef")
                        .requestMatchers("/Inventory/Delete").hasRole("Admin")
                        .requestMatchers("/Order/Active/Get").hasAnyRole("Admin", "Waiter")
                        .requestMatchers("/Order/Post").permitAll()
                        .requestMatchers("/Order/Update/**").hasAnyRole("Admin", "Waiter", "Chef")
                        .requestMatchers("/Order/Delete").hasRole("Admin")
                        .requestMatchers("/Categories/**").hasAnyRole("Admin", "Manager")
                        .requestMatchers("/Ingredients/Get").hasAnyRole("Admin", "Manager", "Chef")
                        .requestMatchers("/Ingredients/Post").hasAnyRole("Admin", "Manager")
                        .requestMatchers("/Ingredients/Update").hasAnyRole("Admin", "Manager")
                        .requestMatchers("/Ingredients/Delete").hasAnyRole("Admin", "Manager")
                        .requestMatchers("/Recipes/Get").hasAnyRole("Admin", "Chef", "Manager")
                        .requestMatchers("/Recipes/Post").hasAnyRole("Admin", "Chef")
                        .requestMatchers("/Recipes/Update").hasAnyRole("Admin", "Chef")
                        .requestMatchers("/Recipes/Delete").hasAnyRole("Admin", "Chef")
                        .requestMatchers("/Customer/Get").hasAnyRole("Admin", "Manager")
                        .requestMatchers("/Customer/Update").hasAnyRole("Admin", "Customer")
                        .requestMatchers("/Customer/Delete").hasAnyRole("Admin")
                        .requestMatchers("/Order_items").hasAnyRole("Admin")
                        .requestMatchers("/Order_item/Post").hasAnyRole("Admin", "Waiter")
                        .requestMatchers("/Order_item/Update").hasAnyRole("Admin", "Waiter")
                        .requestMatchers("/Order_item/Delete").hasAnyRole("Admin", "Waiter")
                        .requestMatchers("/DashBoard/**").hasRole("Admin")
                        .anyRequest().authenticated()
                )
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}