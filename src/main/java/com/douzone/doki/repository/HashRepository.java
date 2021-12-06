package com.douzone.doki.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.douzone.doki.vo.HashVo;

@Mapper
@Repository
public interface HashRepository {
	
	public List<HashVo> getHashList(Long no);

	
	
}