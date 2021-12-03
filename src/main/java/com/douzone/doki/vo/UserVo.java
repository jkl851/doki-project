package com.douzone.doki.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class UserVo {
    private Long no;
    private String id;
    private String password;
    private String userName;
    private String image;
    private String position;
    private String comment;
    private String email;
    
}
