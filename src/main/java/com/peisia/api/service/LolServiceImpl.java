package com.peisia.api.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peisia.api.dto.SearchDto;
import com.peisia.api.dto.userInfoDto;
import com.peisia.api.dto.lolDto.lol;
import com.peisia.api.mapper.Mapper;
import com.peisia.api.service.util.LolUtil;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class LolServiceImpl implements LolService{

	@Setter(onMethod_ = @Autowired)
	private Mapper mapper;	
	@Setter(onMethod_ = @Autowired)
	private LolUtil util;	

	@Override
	public userInfoDto searchUser(String search) {
	
		return mapper.userInfoSelect(search);
	}
	
	@Override
	public lol UserInfo(SearchDto search) {
	lol userInfo = new lol();
	try {
		
	String puuid = util.getPuuid(search.getUserName(),search.getUserTag()).getPuuid();
	userInfo.setSummoner(util.getSummoner(puuid));
	userInfo.setChampionMastery(util.getChampionMastery(puuid));
	userInfo.setMatchID(util.getMatchID(puuid,search.getPage()));
	if(puuid != null && !puuid.equals(null)) {
		
		
	}
	} catch (Exception e) {
	}
		return userInfo;
	}
	
    
    
	}
