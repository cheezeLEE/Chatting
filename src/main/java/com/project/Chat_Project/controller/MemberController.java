package com.project.Chat_Project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.Chat_Project.domain.MemberVO;
import com.project.Chat_Project.service.MemberService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	//회원가입
	@PostMapping("/user")
	public String join(Model model, MemberVO memberVO) {
		System.out.println("start");
		System.out.println(memberVO.getUser_name());
		memberService.register(memberVO);
		return "/login";
	}
	
//	@GetMapping("/join")
//	public String joinForm() {
//		return "/join";
//	}
	
	//로그아웃
	@GetMapping("/logout")
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
		return "redirect:/login";
	}
}
