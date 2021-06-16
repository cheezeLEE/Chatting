package com.project.Chat_Project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Chat_Project.domain.MemberVO;
import com.project.Chat_Project.mapper.TestMapper;
import com.project.Chat_Project.service.TestService;

@Service
public class TestServiceImpl implements TestService{
	
	@Autowired
	private TestMapper testMapper;

	@Override
	public String getTime() {
		return testMapper.getTime();
	}

	@Override
	public MemberVO selectMember() {
		return testMapper.selectMember();
	}
}
