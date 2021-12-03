package com.douzone.doki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.doki.repository.ChatRepository;
import com.douzone.doki.vo.ChatVo;

@Service
public class ChatService {

	@Autowired
	private ChatRepository chatRepository;
	
	public void insert(ChatVo chatVo) {
		chatRepository.insert(chatVo);
	}
	
}