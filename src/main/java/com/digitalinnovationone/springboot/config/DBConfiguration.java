package com.digitalinnovationone.springboot.config;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
@Setter
@Getter
public class DBConfiguration {
    private String driverClassName;
    private String url;
    private String username;
    private String password;

    @Profile("dev")
    @Bean
    public String testDatabaseConnection(){
        System.out.println("DB CONNECTION FOR DEV - H2");
        System.out.println(driverClassName);
        System.out.println(url);
        return "DB CONNECTION TEST TO H2_TEST - TEST INSTANCE";
    }

    @Profile("prod")
    @Bean
    public String prodDatabaseConnection(){
        System.out.println("DB CONNECTION FOR PRODUCTION - POSTGRESQL");
        System.out.println(driverClassName);
        System.out.println(url);
        return "DB CONNECTION TEST TO POSTGRES_PRODTEST - PRODUCTION INSTANCE";
    }
}
