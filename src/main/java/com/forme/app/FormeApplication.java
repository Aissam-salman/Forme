package com.forme.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

/**
 * The type Forme application.
 */
@SpringBootApplication
@PropertySource("classpath:sendgrid.env")
public class FormeApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(FormeApplication.class, args);
    }

}
