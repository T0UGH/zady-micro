package com.edu.neu.zadymicrocommon.feign;

import com.edu.neu.zadymicrocommon.exception.DegradeException;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;


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