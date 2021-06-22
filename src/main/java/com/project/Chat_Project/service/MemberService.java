package com.project.Chat_Project.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.project.Chat_Project.domain.MemberVO;

public interface MemberService extends UserDetailsService{
	//회원가입
	public Long register(MemberVO vo);
	
	public String searchId(MemberVO vo);
}
