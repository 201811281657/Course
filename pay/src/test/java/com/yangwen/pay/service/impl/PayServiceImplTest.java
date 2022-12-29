package com.yangwen.pay.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class PayServiceImplTest {
    @Autowired
    private PayServiceImpl payService;
    @Test
    void create() {
        payService.create("202204958967511213", BigDecimal.valueOf(0.01));

    }
}