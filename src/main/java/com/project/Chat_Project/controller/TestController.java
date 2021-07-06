package com.project.Chat_Project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.Chat_Project.service.TestService;

@Controller
public class TestController {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private TestService testService;
	
//	@RequestMapping(value="/", method=RequestMethod.GET)
//	public String test(Model model) {
//		model.addAttribute("test", testService.getTime());
//		log.trace("trace");
//		log.error("error");
//		log.info("info");
//		log.debug("debug");
//		log.warn("warn");
//		testService.selectMember();
//		return "test";
//	}
}
