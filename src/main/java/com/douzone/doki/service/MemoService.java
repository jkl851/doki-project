package com.douzone.doki.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.douzone.doki.repository.MemoRepository;
import com.douzone.doki.vo.MemoVo;

@Service
@Transactional(readOnly = true)
public class MemoService {

    @Autowired
    private MemoRepository memoRepository;

    // @Autowired
    // private HashRepository hashRepository;

    public List<MemoVo> getListByGroup(Long groupNo) {
	return memoRepository.getListByGroup(groupNo);
    }

    public boolean changeColor(MemoVo vo) {
	return memoRepository.changeColor(vo);
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
    public boolean addMemoHash(MemoVo vo) {
	return memoRepository.addMemoHash(vo);
    }

    @Transactional
    public boolean addMemoAlarm(MemoVo vo) {
	return memoRepository.addMemoAlarm(vo);
    }

    @Transactional
    public boolean setPin(MemoVo vo) {
	return memoRepository.setPin(vo);

    }

    @Transactional
    public boolean setImportant(MemoVo vo) {
	return memoRepository.setImportant(vo);

    }

    public List<MemoVo> getMemoListByHash(MemoVo vo) {
	return memoRepository.getMemoListByHash(vo);
    }

    public List<MemoVo> getAllHashList() {
	return memoRepository.getAllHashList();
    }

}