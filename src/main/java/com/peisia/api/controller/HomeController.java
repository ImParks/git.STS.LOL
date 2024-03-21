package com.peisia.api.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;


@Log4j
@Controller
public class HomeController {
	

	@RequestMapping("/")
	public String home(){


		return "/home";
	}
	
}
	