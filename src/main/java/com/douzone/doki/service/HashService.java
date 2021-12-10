package com.douzone.doki.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.doki.repository.HashRepository;
import com.douzone.doki.vo.HashVo;

@Service
public class HashService {
	@Autowired
	private HashRepository hashRepository;

	public List<HashVo> getHashList(Long no) {
		return hashRepository.getHashList(no);
	}


}