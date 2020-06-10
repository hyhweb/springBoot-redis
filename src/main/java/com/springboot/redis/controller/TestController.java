package com.springboot.redis.controller;

import com.springboot.redis.common.Bean.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/** Created by hyhong Administrator on 2019/10/12. */
@RestController
public class TestController {
  @Autowired private RedisUtil redisUtil;

  @GetMapping("/setString")
  public String setString(String key, String value) {
    redisUtil.set(key, value);
    return value;
  }

  @GetMapping("/getString")
  public String getString(String key) {
    return redisUtil.get(key).toString();
  }



  @GetMapping("/remove")
  public String remove(String key){
      redisUtil.del(key);
      return key;
  }

  @GetMapping("/setHash")
  public Map<String, Object> setHash() {
    String key = "map";
    Map<String, Object> map = new HashMap<String, Object>();
      List list = new ArrayList();
      for (int i = 0; i < 20; i++) {
          Map<String, Object> map1 = new HashMap<String, Object>();
          map1.put("name", "hyh");
          map1.put("sex", "1");
          list.add(map1);
      }
    map.put("userList", list);
    map.put("name", "hyh");
    map.put("sex", "1");
    redisUtil.hmset(key, map);
    return map;
  }

  @GetMapping("/getHash")
  public Map<Object, Object> getHash(String key) {
    return redisUtil.hmget(key);
  }
    @GetMapping("/deleteHashMap")
    public String deleteHashMap(String key,String item){
        redisUtil.hdel(key,item);
        return item.toString();
    }
  @GetMapping("/setList")
  public List setList() {
    List list = new ArrayList();
    for (int i = 0; i < 20; i++) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "hyh");
        map.put("sex", "1");
        list.add(map);
    }
    redisUtil.lSet("user", list);
    return list;
  }
  @GetMapping("getList")
    public List getList(){
    return redisUtil.lGet("user", 0, 20);
  }
    @GetMapping("/deleteList")
    public long deleteList(String key, long count, Object value) {
        return   redisUtil.lRemove(key, count, value);
    }
  @GetMapping("/setSet")
    public void setSet(){
      Map<String, Object> map = new HashMap<String, Object>();
      map.put("name", "hyh");
      map.put("sex", "1");
      redisUtil.sSet("set", "abc");
      redisUtil.sSet("set", "123");
      redisUtil.sSet("set", map);
  }
  @GetMapping("/getSet")
    public Set<Object> getSet(){
    return redisUtil.sGet("set");
  }
  @GetMapping("/removeSet")
    public String removeSet(String key,String value){
    redisUtil.setRemove(key, value);
    return "seccess";
  }
}
