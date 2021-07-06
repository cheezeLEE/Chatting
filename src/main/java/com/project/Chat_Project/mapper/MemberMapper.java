package com.project.Chat_Project.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.project.Chat_Project.domain.MemberVO;

@Mapper
public interface MemberMapper {
	
	//id로 회원정보 검색
	public MemberVO selectById(String id);
	
	//회원등록 
	public Long registerMember(MemberVO vo);
	
	//id 중복확인
//	public int idCheck(String userId);
	
	//아이디 찾기
	public String searchId(MemberVO vo);
	
	//비밀번호 찾기 : 입력된 정보를 가진 사용자를 조회 -> 비밀번호 재설정 (입력받기 -> 암호화 -> 저장)
	//비밀번호찾기 : 사용자 조회
	public int searchMember(MemberVO vo);
	
	//비밀번호찾기 : 비밀번호 재설정
	public void changePw(MemberVO vo);
}
