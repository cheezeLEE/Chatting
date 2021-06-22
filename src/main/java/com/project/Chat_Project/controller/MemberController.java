package com.project.Chat_Project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberService;
	
	//회원가입
	@PostMapping("/user")
	public String join(Model model, MemberVO vo) {
		logger.info("회원가입 시도");
		logger.info("아이디 : "+vo.getUserId());
		memberService.register(vo);
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
		logger.info("로그아웃 시도");
		return "redirect:/login";
	}
	
	//아이디 찾기
	@PostMapping("/searchId")
	public String searchId(Model model, MemberVO vo) {
		logger.info("아이디찾기 시도");
		model.addAttribute("searchId", memberService.searchId(vo));
		return "/resultId";
	}
}
