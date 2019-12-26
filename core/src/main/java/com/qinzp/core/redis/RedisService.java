package com.qinzp.core.redis;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName RedisService
 * @Description: No Description
 * @author: tanbaocai
 * @date: 2018/5/15 14:25
 */
@Component
public class RedisService {
	@Resource
	private StringRedisTemplate template;

	@Resource
	private RedisTemplate<String,Object> redisTemplate;


	/**
	 * fifo
	 * @param listKey
	 * @param value
	 */
	public void firstIn(String listKey,String value) {
		redisTemplate.boundListOps(listKey).rightPush(value);
	}

	/**
	 * fifo阻塞
	 * @param listKey
	 * @return
	 */
	public Object bFirstOut(String listKey,int seconds) {
		return redisTemplate.boundListOps(listKey).leftPop(seconds,TimeUnit.SECONDS);
	}

	/**
	 * 获取并加一
	 * @param key
	 * @return
	 */
	public Long getAndIncr(String key) {
		RedisAtomicLong redisAtomicLong = new RedisAtomicLong(key,redisTemplate.getConnectionFactory());
		Long counter = redisAtomicLong.getAndIncrement();
		redisAtomicLong.expire(100,TimeUnit.DAYS);
		return counter;
	}

	/**
	 * 设置值，并设置超时时间
	 * @param key
	 * @param value
	 * @param timeExpire
	 * @param timeUnit
	 */
	public void setValue(String key, String value, long timeExpire, TimeUnit timeUnit) {
		template.opsForValue().set(key,value,timeExpire,timeUnit);
	}

	/**
	 * 获取值，并删除
	 * @param key
	 * @param delete 是否删除
	 * @return
	 */
	public String getValue(String key,boolean delete) {
		String result = template.opsForValue().get(key);
		if (delete && result!=null) {
			template.delete(key);
		}
		return result;
	}

	public String getValue(String map,String key) {
		return (String) template.opsForHash().get(map,key);
	}

	public Map<Object,Object> getMap(String key) {

		return template.opsForHash().entries(key);

	}
	public void setValue(String map,String key,String value) {
		template.opsForHash().put(map,key,value);
	}

	public void setSetValue(String key, String value) {
		template.opsForSet().add(key,value);
	}

	public Boolean isSetMember(String key,String value){
		return !StringUtils.isEmpty(value) && template.opsForSet().isMember(key,value);
	}

	public void removeMember(String setKey,String setValue){
		template.opsForSet().remove(setKey,setValue);
	}
}
