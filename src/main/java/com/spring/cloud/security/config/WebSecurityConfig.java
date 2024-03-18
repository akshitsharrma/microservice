package com.spring.cloud.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {
    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.httpBasic(Customizer.withDefaults());
        http.authorizeHttpRequests(auth -> auth.requestMatchers(HttpMethod.GET, "/cuponapi/cupons/**")
                .hasAnyRole("USER", "ADMIN").requestMatchers(HttpMethod.POST, "/cuponapi/cupons").hasRole("ADMIN"));
        http.csrf(csrf -> csrf.disable());
        return http.build();
    }
}
