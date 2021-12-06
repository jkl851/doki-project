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

    @PostMapping("/changeColor")
    public String changeColor() {
	// 테스트용 vo(param으로 가져와야한다)
	MemoVo memoVo = new MemoVo();
	memoVo.setNo(28L);
	memoVo.setColor("blue");

	memoService.changeColor(memoVo);
	return "color changed";
    }

    @PostMapping("/addMemo")
    public void addMemo() {
	// 가져올 param 목록
	// MemoVo(memoAlarmTime, repetition도 포함되어 있음, hashName은 X)

	// test vo, addMemo의 param으로 받아온다
	MemoVo memoVo = new MemoVo();
	memoVo.setUserNo(10L);
	memoVo.setDepartmentNo(1L);

	// 0. hash 추가하는 작업!!
	// 1. frontend에서 hash를 추가하는 작업을하고 backend에서 memo 추가 및 memo_hash 추가 작업을 한다
	// 2. memo를 먼저 추가한 후 memo no를 가져온다
	// 3. addMemo()의 param으로 넘어온 hsahNo 배열을 memoVo로 받는다?

	// add memo
	memoService.addMemo(memoVo); // 추가된 memo의 no가 vo에 담겨져 온다

	// 넘어온 해시의 개수
	// int hashCount = memoVo.gethashNo().length?
	// if(hashCount > 0)
	// for문(hashCount 만큼 memo_hash에 insert)

	// 테스트용 hash 넣기 (front에서 처리해야한다)
	System.out.println(memoService.addHash("잇힝"));

	// 테스트용 hashNo
	memoVo.setHashNo(20L);
	// 메모 no와 해당 해시 no를 이용한다
	System.out.println(memoService.addMemoHash(memoVo)); // memo_hash 테이블에도 insert

	// 위의 추가된 메모 하나를 select로 가져와서 화면에 다시 뿌리기?(front에서 처리가 가능하다면 여기선 불필요)
	// memoService.getMemoList(memoVo.getNo());

	// 테스트용 vo
	memoVo.setMemoAlarmTime("2021-12-06 17:30:25");
	memoVo.setRepetition("0");

	// alarm 설정이 있다면 추가
	if (!memoVo.getMemoAlarmTime().isEmpty()) {
	    memoService.addMemoAlarm(memoVo);
	}
    };

    @GetMapping("/list01") // 메모T+메모알람T+메모해쉬MT+해쉬T - 그룹페이지로 이동시 가져올 데이터
    public ResponseEntity<List<MemoVo>> GetUsers(
    // memoVo 받아오기
    ) {
	Long groupNo = 1L;

	if (memoService.getListByGroup(groupNo) == null) {
	    System.out.println(ResponseEntity.notFound().build());
	    return ResponseEntity.notFound().build();
	}

	List<MemoVo> result = memoService.getListByGroup(groupNo);
	System.out.println(result);
	System.out.println("==========================================");
	return ResponseEntity.ok().body(result);
    };

    @PostMapping("/setPin")
    public String setPin() {
	// 테스트용 vo(param으로 가져와야한다)
	MemoVo memoVo = new MemoVo();
	memoVo.setNo(28L);
	memoVo.setPin("0");

	memoService.setPin(memoVo);
	return "pin changed";
    }

    @PostMapping("/setImportant")
    public String setImportant() {
	// 테스트용 vo(param으로 가져와야한다)
	MemoVo memoVo = new MemoVo();
	memoVo.setNo(28L);
	memoVo.setImportant("1");

	memoService.setImportant(memoVo);
	return "Important changed";
    }

    @GetMapping("/getMemoListByHash")
    public List<MemoVo> getMemoListByHash() {
	// 테스트용 vo(param으로 가져와야한다)
	MemoVo memoVo = new MemoVo();
	memoVo.setHashName("잇힝");

	// 특정 해시를 클릭하면 해당 해시를 가진 메모 리스트를 불러온다 
	List<MemoVo> result = memoService.getMemoListByHash(memoVo);
	System.out.println(result);
	System.out.println("==========================================");
	return result;
    }
    
    @GetMapping("/getAllHashList")
    public List<MemoVo> getAllHashList(){
	
	List<MemoVo> result = memoService.getAllHashList();
	System.out.println(result);
	System.out.println("==========================================");
	return result;
    }


}