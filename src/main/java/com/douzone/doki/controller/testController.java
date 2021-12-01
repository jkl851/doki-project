package com.douzone.doki.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.doki.vo.test;

@RestController
public class testController {
    @Autowired
    private SqlSession sqlSession;
    @RequestMapping({"","/main"})
	public String index(Model model) {
		
		return sqlSession.selectOne("test.test");
	}
}
