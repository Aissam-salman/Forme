package com.forme.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Demo controller.
 */
@RestController
@RequestMapping("/api/v1")
public class DemoController {
    /**
     * Hello string.
     *
     * @return the string
     */
    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
}
