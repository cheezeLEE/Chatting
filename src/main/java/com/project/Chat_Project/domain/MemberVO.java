package com.project.Chat_Project.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberVO {
	private String userId;
	private String userName;
	private String userPw;
	private char userGender;
	private String userEmail;
	private Date userRegDate;
	private char userDeletedYn;
}
