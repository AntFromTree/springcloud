package com.cqust.client;

import com.cqust.client.hystrix.OrderFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author huangyijie
 * @date 2024-01-04
 */
@FeignClient(value = "order",fallbackFactory = OrderFallbackFactory.class)
public interface OrderClient {

    @RequestMapping(method = RequestMethod.GET,value = "/getTodayFinishOrderNum/{id}")
    Integer getTodayFinishOrderNum(@PathVariable("id") Integer id);
}
