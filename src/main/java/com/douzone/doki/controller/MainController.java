package com.douzone.doki.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.douzone.doki.service.ChatService;
import com.douzone.doki.service.MemoService;
import com.douzone.doki.service.UserService;
import com.douzone.doki.vo.ChatVo;
import com.douzone.doki.vo.MemoVo;
import com.douzone.doki.vo.UserVo;

@Controller
public class MainController {

	@Autowired
	private UserService userService;

	@Autowired
	private MemoService memoService;
	
	@Autowired
	private ChatService chatService;
	
//	@RequestMapping("")
//	public String index() {
//		return "main/index";
//	}
	
	
	//Jblog방식으로 page 호출
	//	=> 없을시 DOKI 메인페이지 
	//	=> 있을시 해당 부서페이지 
	@RequestMapping({"","/{departmentNo}"})
	public String main(@PathVariable("departmentNo") Optional<Long> departmentNo) {
		//부서번호 확인 / 아무것도없을시 1번 부서 반환
		System.out.println("부서 : " + departmentNo.orElse(1L));
		
		//에러처리 필요한가?
		if(userService.getUserList(departmentNo.orElse(1L)) == null) {
			System.out.println("유저 못불러옴 오류");
			
			return null;
		}
		
		//그룹내 직원리스트
		//유저번호, 유저이름, 유저이미지, 유저 직책, 유저 권한 호출
		List<UserVo> userList = userService.getUserList(departmentNo.orElse(1L));
		
		//유저리스트를 담는 작업
		//model? map?
		
		
		//그룹내 메모리스트
		List<MemoVo> memoList = memoService.getListByGroup(departmentNo.orElse(1L));
		
		//메모리스트를 담는 작업
		
		

		//그룹내 채팅 리스트
		List<ChatVo> chatList = chatService.getChatList(departmentNo.orElse(1L));
		
		//메모리스트를 담는 작업
		for(ChatVo i: chatList) {
			System.out.println(i.getMessage());
		}
		
		
		return "해당부서 페이지";
	}	
	
	
}
