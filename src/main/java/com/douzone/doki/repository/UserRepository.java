package com.douzone.doki.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.douzone.doki.vo.UserVo;

@Mapper
@Repository
public interface UserRepository {
	
	public boolean updateUser(UserVo vo);
	
	
//    public boolean changeColor();
//    public List<MemoVo> getListByGroup(Long groupNo);
	
	public UserVo findByNo(Long no);
//	{
//		return sqlSession.selectOne("user.findByNo", no);
//	}

//	{
//		int count = sqlSession.update("user.update", vo);
//		return count;
//	}

}