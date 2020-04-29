package com.edu.neu.zadymicroreport.util;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import feign.Response;
import feign.codec.DecodeException;
import feign.codec.Decoder;

import java.io.IOException;
import java.lang.reflect.Type;

public class FeignClientDecoder implements Decoder {
    @Override
    public Object decode(Response response, Type type) throws IOException, DecodeException, FeignException {
        ObjectMapper objectMapper = new ObjectMapper();
        // 将response转为json
        JSONObject jsonObject = objectMapper.readValue(response.body().asInputStream(), JSONObject.class);
        // 如果UserService处理失败, 抛出异常
        if (!"200".equals(jsonObject.getString("code"))) {
            throw new RuntimeException("发生了异常");
        }

        if(type.getTypeName().equals("java.lang.Integer")){
            return jsonObject.getInteger("body");
        }

        // 将data转为目标类型
        return jsonObject.getJSONObject("body").toJavaObject(type);
    }
}
