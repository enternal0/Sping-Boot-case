package com.dan.boot.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping(value = "/redis")
public class RedisController {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> add(@RequestParam("key") String key, @RequestParam("value") String value) {
        redisTemplate.opsForValue().set(key, value);
        Map<String, String> data = new HashMap<>();
        data.put(key, value);
        return data;
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> query(@RequestParam("key") String key) {
        Map<String, String> data = new HashMap<>();
        String value = redisTemplate.opsForValue().get(key);
        data.put(key, value);
        return data;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> delete(@RequestParam("key") String key) {
        String value = redisTemplate.opsForValue().get(key);
        redisTemplate.delete(key);
        Map<String, String> data = new HashMap<>();
        data.put(key, value);
        return data;
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> list(@RequestParam("key") String key) {
        Map<String, String> data = new HashMap<>();
      //要求是key的类型必须是string
        Set<String> keys = redisTemplate.keys(key);
        for (String k : keys) {
            if (redisTemplate.type(k) == DataType.STRING) {
                data.put(k, redisTemplate.opsForValue().get(k));
            }
        }
        return data;
    }


}
