package com.douzone.doki.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class MemoVo {
	
    private Long no;
    private String contents;
    private String color;
    private String regDate;
    private String pin;
    private String important;
    private String userNo;
    
}
