package com.douzone.doki.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.douzone.doki.vo.MemoVo;

@Repository
@Mapper
public interface MemoRepository {
    public boolean changeColor(MemoVo vo);
    public boolean addMemo(MemoVo vo);
    public boolean addHash(String hashName);
    public boolean addMemoHash(MemoVo vo);
    public boolean addMemoAlarm(MemoVo vo);
    public boolean setPin(MemoVo vo);
    public boolean setImportant(MemoVo vo);
    public List<MemoVo> getListByGroup(Long groupNo);
    public List<MemoVo> getMemoListByHash(MemoVo vo);
    public List<MemoVo> getAllHashList();
    
	public boolean modifyMemo(MemoVo vo);
	public MemoVo findMemo(Long no);
}