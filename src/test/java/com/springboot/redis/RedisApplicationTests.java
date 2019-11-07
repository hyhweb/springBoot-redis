package com.springboot.redis;

import com.springboot.redis.common.Bean.util.RedisUtil;
import com.springboot.redis.service.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisApplicationTests {
  @Autowired RedisService redisService;
  @Autowired RedisUtil redisUtil;

  @Test
  public void contextLoads() {
    /*redisService.hello();
    redisService.hello2();*/
    redisUtil.set("flutter", "hyh");
    String text =  (String) redisUtil.get("flutter");
    System.out.println(text);
  }
}
