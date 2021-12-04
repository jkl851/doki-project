package com.douzone.doki.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.douzone.doki.vo.UserVo;

@Mapper
@Repository
public interface UserRepository {
	
	public boolean updateUser(UserVo vo);
	public UserVo findByNo(Long no);
	public List<UserVo> getUserList(Long no);

	
	
}