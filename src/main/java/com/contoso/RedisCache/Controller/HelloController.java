package com.contoso.RedisCache.Controller;

import ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@RestController
public class HelloController {

    @Autowired
    private StringRedisTemplate template;

    @RequestMapping("/")
    // Define the Hello World controller.
    public String hello() {

        ValueOperations<String, String> ops = this.template.opsForValue();

        // Add a Hello World string to your cache.
        String key = "greeting";
        if (!this.template.hasKey(key)) {
            ops.set(key, "Hello World!");
        }

        // Return the string from your cache.
        return ops.get(key);
    }
    @GetMapping("/GetKey")
    public String test()
    {
        ValueOperations<String,String> ops=this.template.opsForValue();
        String key="test";
        if (!this.template.hasKey(key))
        {
            ops.set(key,"test1");
        }
        return ops.get(key);
    }
}