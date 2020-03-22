package com.spring.users.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/login").setViewName("login");
    }
}
