package com.cqust.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangyijie
 * @date 2024-01-04
 */
@RequestMapping
@RestController("/api/order")
public class OrderController {
    @Value("${server.port}")
    private Integer port;

    @GetMapping("/getTodayFinishOrderNum/{id}")
    public Integer getTodayFinishOrderNum(@PathVariable("id") Integer id){
        return port;
    }
}
