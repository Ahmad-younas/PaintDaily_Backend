package com.example.backend.config;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class ResourceConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String path = "file://C:/backend/src/main/resources/static/images/";
        registry.addResourceHandler("/content/**").addResourceLocations(path);
    }
}
