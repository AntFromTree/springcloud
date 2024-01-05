package com.cqust.controller;

import com.cqust.client.OrderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author huangyijie
 * @date 2024-01-04
 */
@RestController
@RequestMapping("/user")
@EnableFeignClients
public class UserController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private OrderClient orderClient;

    @GetMapping("/getTodayStatistic/{id}")
    public Integer getTodayStatistic(@PathVariable("id") Integer id){
        return orderClient.getTodayFinishOrderNum(id);
    }
}
