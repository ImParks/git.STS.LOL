package com.peisia.api.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peisia.api.dto.SearchDto;
import com.peisia.api.dto.userInfoDto;
import com.peisia.api.dto.lolDto.lol;
import com.peisia.api.dto.lolDto.matchDto.Match;
import com.peisia.api.mapper.Mapper;
import com.peisia.api.service.util.Util;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class LolServiceImpl implements LolService {

	@Setter(onMethod_ = @Autowired)
	private Mapper mapper;
	@Setter(onMethod_ = @Autowired)
	private Util util;

	@Override
	public userInfoDto searchUser(String search) {

		return mapper.userInfoSelect(search);
	}

	@Override
	public lol UserInfo(SearchDto search) {
		lol userInfo = new lol();
		try {

			search.setPuuid(util.getPuuid(search.getUserName(), search.getUserTag()).getPuuid());
			userInfo.setSummoner(util.getSummoner(search.getPuuid()));
//			userInfo.setChampionMastery(util.getChampionMastery(search.getPuuid()));
			userInfo.setMatchID(util.getMatchID(search));
			ArrayList<Match> matchList = new ArrayList<Match>();
			for (String matchId : util.getMatchID(search)) {
				matchList.add(util.getMatch(matchId));
			}
			userInfo.setMatch(matchList);
		} catch (Exception e) {
		}
		return userInfo;
	}

}
