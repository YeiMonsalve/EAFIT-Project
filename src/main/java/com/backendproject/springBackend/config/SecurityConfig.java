package com.backendproject.springBackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authz -> authz.requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html", "/**").permitAll().anyRequest().permitAll()).csrf(csrf -> csrf.disable()).httpBasic(Customizer.withDefaults());

        return http.build();
    }

}