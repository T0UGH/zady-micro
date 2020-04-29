package com.edu.neu.zadymicroreport.fallback;

import com.edu.neu.zadymicroreport.exception.DegradeException;
import feign.hystrix.FallbackFactory;

import org.springframework.stereotype.Component;
/**
 * @author lengleng
 * @date 2019-08-01
 */
@Component
public class DefaultFallBackFactory implements FallbackFactory<Void> {

    @Override
    public Void create(Throwable throwable) {
        if (throwable instanceof com.alibaba.csp.sentinel.slots.block.degrade.DegradeException){
            throw new DegradeException("服务降级");
        }
        throw new RuntimeException(throwable);
    }

}