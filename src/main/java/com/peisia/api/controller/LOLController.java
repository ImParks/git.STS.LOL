package com.peisia.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.peisia.api.dto.SearchDto;
import com.peisia.api.dto.lolDto.LeagueEntry;
import com.peisia.api.dto.lolDto.lol;
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
				lol LOL = service.UserInfo(search);
				
				//0일때 언랭크, 1일때 솔로랭크, 2 일때 자유랭크
				System.out.println(LOL.getLeagueEntry().get(1));
				int[] queueType = {0, 0};
				for (LeagueEntry league : LOL.getLeagueEntry()) {
					if (league.getQueueType().equals("RANKED_SOLO_5x5")) {
						queueType[0]=1;
					} else if (league.getQueueType().equals("RANKED_FLEX_SR")) {
						queueType[1]=2;
					}

				}
				try {
					m.addAttribute("User", search);
					m.addAttribute("Level", LOL.getSummoner().getSummonerLevel());
					m.addAttribute("LeagueEntry", LOL.getLeagueEntry());
					m.addAttribute("queueType", queueType);
					m.addAttribute("Match", LOL.getMatch());
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
