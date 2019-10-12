package com.springboot.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

/**
 * Created by hyhong Administrator on 2019/10/12.
 */
@Service
public class RedisService {
    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    public void hello(){
       // redisTemplate.setKeySerializer(new StringRedisSerializer());
        ValueOperations ops = redisTemplate.opsForValue();
        ops.set("name", "hong111");
        Object o = ops.get("name");
        System.out.println(o);
    }
    public void hello2() {
        ValueOperations ops = stringRedisTemplate.opsForValue();
        ops.set("sex","box-girl222");
        Object o = ops.get("sex");
        System.out.println(o);
    }
}
