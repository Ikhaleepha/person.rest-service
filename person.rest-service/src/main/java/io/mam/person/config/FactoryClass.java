package io.mam.person.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FactoryClass {

    @Bean
    public Logger logger() {
        return LoggerFactory.getLogger(FactoryClass.class);
    }
}
