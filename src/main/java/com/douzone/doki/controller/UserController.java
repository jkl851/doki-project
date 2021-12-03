package com.douzone.doki.controller;

import java.util.HashMap;
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
import com.douzone.doki.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	/*
	 * //회원가입 페이지 이동
	 * 
	 * @RequestMapping(value="/join", method=RequestMethod.GET) public String
	 * join(@ModelAttribute UserVo vo) { return "user/join"; }
	 * 
	 * 
	 * //회원가입
	 * 
	 * @RequestMapping(value="/join", method=RequestMethod.POST) public String
	 * join(UserVo vo, BindingResult result, Model model) { if(result.hasErrors()) {
	 * 
	 * model.addAllAttributes(result.getModel()); return "user/join"; }
	 * 
	 * userService.join(vo); return "redirect:/user/joinsuccess"; }
	 * 
	 * @RequestMapping("/joinsuccess") public String joinsuccess() { return
	 * "user/joinsuccess"; }
	 */
	
	
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
	public String update(UserVo userVo) {
		boolean result = userService.updateUser(userVo);
		
		System.out.println("result : " + result);

		return "redirect:/";
	}
	
	
	//직원 프로필 클릭시 해당 직원 데이터 (부서, 직책, 이미지, 이름, 이메일, 코멘트)
	@ResponseBody
	@GetMapping("/finduser/{no}")
	public ResponseEntity <Map<String, Object>> findUser(@PathVariable("no") Long no) {
//		boolean result = userService.findUser(no) == null ? false : true;
		
		if(userService.findUser(no) == null) {
			System.out.println(ResponseEntity.notFound().build());
			return ResponseEntity.notFound().build();
		}
		
		Map<String, Object> result = new HashMap<>();
		result.put("list", userService.findUser(no));
		System.out.println(result);
		
		return ResponseEntity.ok().body(result);
	}
	
	
	
//	@GetMapping("/list01")
//	public ResponseEntity <Map<String, Object>> GetUsers(
//			// GroupNo 가져오기
//			) {
//		Long groupNo = 1L;
//		
//		if(memoService.getListByGroup(groupNo) == null) {
//			System.out.println(ResponseEntity.notFound().build());
//			return ResponseEntity.notFound().build();
//		}
//		
//		Map<String, Object> result = new HashMap<>();
//		result.put("list", memoService.getListByGroup(groupNo));
//		System.out.println(result);
//		return ResponseEntity.ok().body(result);
//	};
	
	
	
	
	
	
	
	//그룹내 직원 리스트(이미 그룹내에 있는 사람은 체크박스 checked, 직원검색 검색어 입력시 마다 Filtered 리스트)
	
	
	
	//톱니 누를때 그룹내 직원 리스트 (이미 권한에 따라 체크박스 checked, 직원검색 검색어 입력시 마다 Filtered 리스트)
	
	
}
