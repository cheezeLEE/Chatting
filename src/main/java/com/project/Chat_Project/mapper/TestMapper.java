package com.project.Chat_Project.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.project.Chat_Project.domain.MemberVO;

@Mapper
public interface TestMapper {
	public String getTime();
	public MemberVO selectMember();
}
