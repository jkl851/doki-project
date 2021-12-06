package com.douzone.doki.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.douzone.doki.service.HashService;
import com.douzone.doki.vo.HashVo;

@Controller
@RequestMapping("/hash")
public class HashController {
	
	@Autowired
	private HashService hashService;

	//ajax처리
	//직원 프로필 클릭시 해당 직원 데이터 (부서, 직책, 이미지, 이름, 이메일, 코멘트)
	@ResponseBody
	@GetMapping("/getHashList/{no}") //부서번호를 받음.
	public ResponseEntity<List<HashVo>> getHashList(@PathVariable("no") Long no) {
		
		//에러처리
		if(hashService.getHashList(no) == null) {
			System.out.println(ResponseEntity.notFound().build());
			return ResponseEntity.notFound().build();
		}
		
		List<HashVo> hashList = hashService.getHashList(no);
		for(HashVo i: hashList) {
			System.out.print(i.getNo() + " : ");
			System.out.println(i.getName());
		}
		
		//hashList 담는 작업
		//
		
		return ResponseEntity.ok().body(hashList);
	}
	
	
}
