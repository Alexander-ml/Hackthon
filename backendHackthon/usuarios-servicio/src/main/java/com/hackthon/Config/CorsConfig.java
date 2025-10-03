package com.hackthon.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() { // Esto significa que estás creando una configuración personalizada para el MVC (controladores REST)
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Permite cualquier cabecera HTTP, aplica las reglas de CORS a todas las rutas de la API.
                        .allowedOriginPatterns("*") // permite que las peticiones desde el frontend React (puerto 3000) y Angular (puerto 4200) puedan acceder a tu API
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // métodos HTTP que se permiten
                        .allowedHeaders("*") // permite cualquier cabecera HTTP
                        .allowCredentials(true); // permite el uso de cookies, headers de autorización o credenciales en las peticiones
            }
        };
    }
}
