package com.example.movieApp.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//loads API key from app.env w/o hardcoding
@Configuration
public class AppConfig {
    @Bean
    public Dotenv dotenv() {
        return Dotenv.configure().filename("app.env").ignoreIfMissing().load();
    }
}