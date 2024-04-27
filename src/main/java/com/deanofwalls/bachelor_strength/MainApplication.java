package com.deanofwalls.bachelor_strength;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

/**
 * Main Spring Boot Application class.
 * This class usually doesn't need to be renamed.
 */
@SpringBootApplication(scanBasePackages = "com.deanofwalls.bachelor_strength")
@Profile("web")
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
}
