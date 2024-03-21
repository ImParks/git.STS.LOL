package com.peisia.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.peisia.api.service.LolService;

import lombok.Setter;

@RestController
@RequestMapping("/js/*")
public class JSController {

	@Setter(onMethod_ = @Autowired)
	private LolService service;
	
}
