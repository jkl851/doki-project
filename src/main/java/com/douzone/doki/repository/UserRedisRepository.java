package com.douzone.doki.repository;

import org.springframework.data.repository.CrudRepository;

import com.douzone.doki.vo.UserVo;


public interface UserRedisRepository extends CrudRepository<UserVo, String> {
	
}