package com.project.Chat_Project.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.project.Chat_Project.domain.MemberVO;

public interface MemberService extends UserDetailsService{
	//회원가입
	public Long register(MemberVO vo);
	
	//id 중복확인
//	public int idCheck(String userId);
	
	//아이디 찾기
	public String searchId(MemberVO vo);

	//비밀번호 찾기 : 사용자 조회
	public int searchMember(MemberVO vo);
	
	//비밀번호 찾기 : 비밀번호 재설정
	public void changePw(MemberVO vo);
}
