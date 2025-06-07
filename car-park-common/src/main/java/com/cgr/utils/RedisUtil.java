package com.cgr.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {

    public static final Long USER_TOKEN_TTL = 10L;

    @Autowired
    private RedisTemplate redisTemplate;
    public <T> void setCacheObject(String key, T value){
        redisTemplate.opsForValue().set(key, value);
    }

    public <T> void setCacheObject(String key, T value, Long timeout,  TimeUnit unit){
        redisTemplate.opsForValue().set(key, value,timeout,unit);
    }
}
