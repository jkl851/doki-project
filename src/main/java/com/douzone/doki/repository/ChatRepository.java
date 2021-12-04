package com.douzone.doki.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.douzone.doki.vo.ChatVo;
import com.douzone.doki.vo.UserVo;

@Mapper
@Repository
public interface ChatRepository {

	public boolean insert(ChatVo chatVo);
	public List<ChatVo> getChatList(Long no);

}