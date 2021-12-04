package com.douzone.doki.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.douzone.doki.repository.MemoRepository;
import com.douzone.doki.vo.MemoVo;
import com.douzone.doki.vo.UserVo;

@Service
@Transactional(readOnly = true)
public class MemoService {

    @Autowired
    private MemoRepository memoRepository;

    //@Autowired
    //private HashRepository hashRepository;
    
    public List<MemoVo> getListByGroup(Long groupNo) {
    	return memoRepository.getListByGroup(groupNo);
        }
    

    public boolean changeColor() {
	return memoRepository.changeColor();
    }

    @Transactional
    public boolean addMemo(MemoVo vo) {
	return memoRepository.addMemo(vo);
    }

    @Transactional
    public boolean addHash(String hashName) {
	return memoRepository.addHash(hashName);
    }

    @Transactional
    public boolean addMemoHash(Long memoNo, Long hashNo) {
	Map<String, Long> map = new HashMap<>();
	map.put("memoNo", memoNo);
	map.put("hashNo", hashNo);
	System.out.println(map);
	return memoRepository.addMemoHash(map);
    }
    

}