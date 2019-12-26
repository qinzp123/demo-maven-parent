package com.qinzp.content.controller;

import com.qinzp.core.redis.RedisService;
import com.qinzp.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/content")
public class ContentController {

    @Resource
    private RedisService redisService;

    @Autowired
    private UserRepository userRepository;

    @Resource
    private StringRedisTemplate template;

    /**
     * 获取直播地址
     * @param platform
     * @return
     */
    @RequestMapping("/getRedis")
    public String getBorough(String platform) {

        //String url = redisService.getValue(platform,false);
        return "test-redis"+userRepository.findById(1).get();
    }
}