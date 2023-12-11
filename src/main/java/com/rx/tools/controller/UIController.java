package com.rx.tools.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UIController {
	
	@GetMapping("/")
	public String showRegex() {
		return "regex";
	}

}
