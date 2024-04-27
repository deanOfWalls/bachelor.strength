package com.deanofwalls.bachelor_strength.config;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class FitnessConfig {

    @Primary
    @Bean
    public ServletWebServerFactory servletContainerFactory() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        // Additional configuration if needed
        return factory;
    }
}
