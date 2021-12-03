package com.douzone.doki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.doki.repository.UserRepository;
import com.douzone.doki.vo.UserVo;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public UserVo findUser(Long no) {
		return userRepository.findByNo(no);
	}
	

	public boolean updateUser(UserVo userVo) {
		return userRepository.updateUser(userVo);
	}
	
	
}