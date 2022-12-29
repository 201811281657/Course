package com.yangwen.pay.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

public interface IpayService {
    /**
     * 创建并发起支付
     */
    void create(String OderId, BigDecimal amount);
}
