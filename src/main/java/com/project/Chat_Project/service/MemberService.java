package com.project.Chat_Project.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.project.Chat_Project.domain.MemberVO;

public interface MemberService extends UserDetailsService{
	public Long register(MemberVO memberVO);
}
