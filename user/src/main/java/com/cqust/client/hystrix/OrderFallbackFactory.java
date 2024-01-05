package com.cqust.client.hystrix;

import com.cqust.client.OrderClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author huangyijie
 * @date 2024-01-04
 */
@Component
public class OrderFallbackFactory implements FallbackFactory<OrderClient> {

    private static final Logger LOGGER= LoggerFactory.getLogger(OrderFallbackFactory.class);

    @Override
    public OrderClient create(Throwable cause) {
        return new OrderClient() {
            @Override
            public Integer getTodayFinishOrderNum(Integer id) {
                OrderFallbackFactory.LOGGER.error("调用异常:{}",cause);
                return -1;
            }
        };
    }
}
