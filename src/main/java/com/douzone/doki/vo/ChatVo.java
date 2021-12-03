package com.douzone.doki.vo;

import org.springframework.data.redis.core.RedisHash;

import lombok.Data;
import lombok.NonNull;

@Data
@RedisHash(value="user")
public class ChatVo {
	private Long no;
	private String message;
	private String date;
	private Long userNo;
	private Long departmentNo;

}
