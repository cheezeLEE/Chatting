package com.project.Chat_Project.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.project.Chat_Project.domain.MemberVO;

@Mapper
public interface MemberMapper {
	
	//id로 회원정보 검색
	public MemberVO selectById(String id);
	
	//회원등록 
	public Long registerMember(MemberVO vo);
	
}
