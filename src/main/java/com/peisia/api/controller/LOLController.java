package com.peisia.api.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.peisia.api.dto.SearchDto;
import com.peisia.api.service.LolService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/lol/*")
public class LOLController {

	@Setter(onMethod_ = @Autowired)
	private LolService service;

	String nextPage;

	@GetMapping("/userInfo")

	public String UserInfo(SearchDto search, Model m) {
		nextPage = "/home";
		if (search.getGameNameTag().length() >= 1) {
			String[] parts = search.getGameNameTag().split("#", 2);
			if (parts.length == 2) {
					search.setUserName(parts[0]);
					search.setUserTag(parts[1]);
				try {
					m.addAttribute("User", search);
					m.addAttribute("Level", service.UserInfo(search).getSummoner().getSummonerLevel());
					m.addAttribute("championMastery", service.UserInfo(search).getChampionMastery());
					m.addAttribute("matchID", service.UserInfo(search).getMatchID());
					nextPage = "/userSummoner";
				} catch (NullPointerException e) {
					m.addAttribute("User", search);
					nextPage = "/userSearchError";
				}
			}
		} else {
			m.addAttribute("User", search);
			nextPage = "/userSearchError";
		}

		return nextPage;
	}
}
