package com.jsp.usercanada.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	
	@RequestMapping("/first")
	public String firstApi() {
		return "Hii";
	}
	
}
