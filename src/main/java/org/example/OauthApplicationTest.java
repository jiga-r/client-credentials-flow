package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class OauthApplicationTest {
    public static void main(String[] args) {
        SpringApplication.run(OauthApplicationTest.class, args);
    }
}