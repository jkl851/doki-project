package com.douzone.doki.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import com.douzone.doki.vo.ChatVo;

@Component
public class redisTempalate {

	@Autowired
	private RedisTemplate<String,String> redisTemplate;
	
	@Bean
	public void redisString() {

//		ChatVo chatVo = new ChatVo();
//		chatVo.setMessage("set 5");
//		chatVo.setNo(5L);
		// 데이터 주기
//		ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();

//		String key = chatVo.getNo().toString();
//		System.out.println("key : " + key);

		// when
//		valueOperations.set(key, chatVo.getMessage());


		// then
//		String value = valueOperations.get(key);
//		System.out.println("value : " + value);

		//Boolean expire = redisTemplate.expire(key, 5, TimeUnit.SECONDS);
		
	}
	
}