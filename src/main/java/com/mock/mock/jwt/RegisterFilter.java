package com.mock.mock.jwt;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RegisterFilter {
    @Bean
    public FilterRegistrationBean<JwtRequestFilter> registrationBean() {
        FilterRegistrationBean<JwtRequestFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new JwtRequestFilter());
        registration.addUrlPatterns("/api/*"); // Set the pattern to match the URLs that require JWT validation
        return registration;
    }
}
