package com.project.Chat_Project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.Chat_Project.domain.MemberVO;
import com.project.Chat_Project.mapper.MemberMapper;
import com.project.Chat_Project.service.MemberService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberMapper memberMapper;
	
	//Spring Security 필수 메소드 구현 : 로그인 처리
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		try {
			return memberMapper.selectById(userId);			
		} catch (UsernameNotFoundException e) {
			return null;
		}
	}
	
	//회원정보 저장
	public Long register(MemberVO vo) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		vo.setUserPw(encoder.encode(vo.getUserPw()));
		return memberMapper.registerMember(vo);
	}

	//현재 인증된 사용자 정보 조회
	public String authMemberInfo() {
		String user_name;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if(principal instanceof UserDetails) {
			user_name = ((UserDetails)principal).getUsername();
		} else {
			user_name = principal.toString();
		}
		return user_name;
	}

	@Override
	public String searchId(MemberVO vo) {
		return memberMapper.searchId(vo);
	}

	
}
