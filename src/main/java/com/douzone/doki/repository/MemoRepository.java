package com.douzone.doki.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.douzone.doki.vo.MemoVo;
import com.douzone.doki.vo.UserVo;

@Repository
@Mapper
public interface MemoRepository {
    public boolean changeColor();
    public boolean addMemo(MemoVo vo);
    public boolean addHash(String hashName);
    public boolean addMemoHash(Map<String, Long> map);
    public List<MemoVo> getListByGroup(Long groupNo);
	
	
}