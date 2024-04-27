package com.deanofwalls.bachelor_strength;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

/**
 * Main Spring Boot Application class.
 * This class usually doesn't need to be renamed.
 */
@SpringBootApplication(scanBasePackages = {"com.deanofwalls.bachelor_strength", "com.deanofwalls.bachelor_strength.config"})
//@Profile("web")
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
//        SpringApplication app = new SpringApplication(FitnessCLI.class);
//        app.setWebApplicationType(WebApplicationType.SERVLET);
//        app.setAdditionalProfiles("web"); // Ensure the 'cli' profile is active
//        app.run(args);
    }}
