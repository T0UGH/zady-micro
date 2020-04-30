package com.edu.neu.zadymicrocommon.feign;

import com.edu.neu.zadymicrocommon.util.ParamHolder;
import feign.RequestInterceptor;
import feign.RequestTemplate;

public class FeignBasicAuthRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        String token = ParamHolder.getCurrentToken();
        requestTemplate.header("token",token);
    }
}
