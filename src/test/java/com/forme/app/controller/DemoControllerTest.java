package com.forme.app.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DemoControllerTest {
    DemoController demoController = new DemoController();

    @Test
    void testHello() {
        String result = demoController.hello();
        Assertions.assertEquals("Hello word", result);
    }
}

//Generated with love by TestMe :) Please raise issues & feature requests at: https://weirddev.com/forum#!/testme