package com.qinzp.official.controller;

import com.qinzp.core.redis.RedisService;
import com.qinzp.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/official")
public class OfficailController {

    @Resource
    private RedisService redisService;

    @Autowired
    private UserRepository userRepository;

    /**
     * 获取直播地址
     * @param platform
     * @return
     */
    @RequestMapping("/getRedis")
    public String getBorough(String platform) {

        //String url = redisService.getValue(platform,false);
        return "test-redis"+userRepository.findById(2).get();
    }
}
