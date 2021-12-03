package com.douzone.doki.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.doki.service.MemoService;
import com.douzone.doki.vo.MemoVo;

@RestController
public class MemoController {
    @Autowired
    private MemoService memoService;

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String changeColor(
//					@AuthUser SecurityUser securityUser, 
    ) {
	System.out.println(memoService.changeColor());
	return "changeColor";
    }

    @PostMapping("/addMemo")
    public boolean addMemo() {
	// 가져올 param 목록
	// MemoVo(memoAlarmTime, repetition도 포함되어 있음, hashName은..?)
	
	// test vo, addMemo의 param으로 받아온다
	MemoVo memoVo = new MemoVo();
	memoVo.setUserNo(9L);
	memoVo.setDepartmentNo(2L);
	
	// add memo
	boolean result = memoService.addMemo(memoVo);
	// 추가된 메모의 no를 가져오는 방법?(가져와야 밑에 addMemoHash에 파라미터로 넘긴다)
	
	// 해시 추가 설명
	// 1. 메모에 해시가 있다면 hash 테이블에 있는지 검사한 후 insert
	// 2. 파라미터로 해시 name을 넣어준다
	// 3. 해시는 0개 ~ 여러 개 => 해시 개수에 맞게 insert도 여러 개(for문?)
	
	// 넘어온 해시의 개수
	
	// if(memoVo.getHashName())
		// for문?
	
		// 넣을 해시가 hash 테이블에 있는지 검사부터 한다
		// if 테이블에 해시가 없다면
		System.out.println(memoService.addHash("경제"));
	
		// else 테이블에 해시가 있다면 넘어간다(작성 안해도 될듯)
	
		// 메모 no와 해당 해시 no
		System.out.println(memoService.addMemoHash(17L, 10L));	// memo_hash 테이블에도 insert

	// 위의 추가된 메모를 select로 하나 가져와서 화면에 다시 뿌리기?
	// memoService.getMemoList();
	
	return result;
    };
    
    @GetMapping("/list01") // 메모T+메모알람T+메모해쉬MT+해쉬T - 그룹페이지로 이동시 가져올 데이터
	public ResponseEntity <List<MemoVo>> GetUsers(
			//groupNo 받아오기
			) {
		Long groupNo = 1L;

		if(memoService.getListByGroup(groupNo) == null) {
			System.out.println(ResponseEntity.notFound().build());
			return ResponseEntity.notFound().build();
		}
		
		List <MemoVo> result = memoService.getListByGroup(groupNo);
		System.out.println(result);
		System.out.println("==========================================");
		return ResponseEntity.ok().body(result);
	};

}