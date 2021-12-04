package com.douzone.doki.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.doki.repository.ChatRepository;
import com.douzone.doki.vo.ChatVo;
import com.douzone.doki.vo.UserVo;

@Service
public class ChatService {

	@Autowired
	private ChatRepository chatRepository;
	
	public void insert(ChatVo chatVo) {
		chatRepository.insert(chatVo);
	}
	
	public List<ChatVo> getChatList(Long departmentNo) {
		return chatRepository.getChatList(departmentNo);
	}
	
	
}