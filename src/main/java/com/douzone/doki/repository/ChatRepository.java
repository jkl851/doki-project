package com.douzone.doki.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.douzone.doki.vo.ChatVo;

@Mapper
@Repository
public interface ChatRepository {

	public boolean insert(ChatVo chatVo);

}