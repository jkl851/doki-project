package com.douzone.doki.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.douzone.doki.dto.JsonResult;
import com.douzone.doki.service.UserService;
import com.douzone.doki.vo.HashVo;
import com.douzone.doki.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	//로그인 페이지
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		return "user/login";
	}
	
	//로그아웃
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout() {
		return "user/login";
	}
	
	//회원 수정완료시 유저 정보 업데이트 및 리다이렉트
	@PostMapping("/update")
	public void update(UserVo userVo) {
		boolean result = userService.updateUser(userVo);
		
		System.out.println("result : " + result);

//		return "redirect:/";
	}
	

	
	
	//ajax처리
	//직원 프로필 클릭시 해당 직원 데이터 (부서, 직책, 이미지, 이름, 이메일, 코멘트)
	@ResponseBody
	@GetMapping("/finduser/{no}")
	public ResponseEntity <Map<String, Object>> findUser(@PathVariable("no") Long no) {
//		boolean result = userService.findUser(no) == null ? false : true;
		
		//에러처리
		if(userService.findUser(no) == null) {
			System.out.println(ResponseEntity.notFound().build());
			return ResponseEntity.notFound().build();
		}
		
		Map<String, Object> result = new HashMap<>();
		result.put("list", userService.findUser(no));
		System.out.println(result);
		
		return ResponseEntity.ok().body(result);
	}
	
	
	//ajax처리
	//직원 프로필 클릭시 해당 직원 데이터 (부서, 직책, 이미지, 이름, 이메일, 코멘트)
	@ResponseBody
	@GetMapping("/getUserList/{no}") //부서번호를 받음.
	public ResponseEntity<List<UserVo>> getUserList(@PathVariable("no") Long no) {
		
		//에러처리
		if(userService.getUserList(no) == null) {
			System.out.println(ResponseEntity.notFound().build());
			return ResponseEntity.notFound().build();
		}
	 
		
		List<UserVo> userList = userService.getUserList(no);

		for(UserVo i: userList) {
			System.out.print(i.getUserName() + " : ");
			System.out.println(i.getAuth());
		}
		
		//userList 담는 작업
		//
		
		return ResponseEntity.ok().body(userList);
	}

	
}
