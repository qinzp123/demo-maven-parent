package com.qinzp.core.controller;

import com.qinzp.core.redis.RedisService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/redis")
public class RedisController {

	@Resource
	private RedisService redisService;

	/**
	 * 获取直播地址
	 * @param platform
	 * @return
	 */
	@RequestMapping("/getRedis")
	public String getBorough(String platform) {

		//String url = redisService.getValue(platform,false);
		return "test-redis";
	}
}
