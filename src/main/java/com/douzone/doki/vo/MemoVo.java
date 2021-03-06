package com.douzone.doki.vo;

import lombok.Data;

@Data
public class MemoVo {
    private Long no;
    private String contents;
    private String color;
    private String regDate;
    private String pin;
    private String important;
    private Long userNo;
    private Long departmentNo;
    private Long hashNo;
    private String hashName;
    private String memoAlarmTime;
    private String repetition;
    
}