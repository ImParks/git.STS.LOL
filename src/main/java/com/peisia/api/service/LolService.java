package com.peisia.api.service;

import com.peisia.api.dto.SearchDto;
import com.peisia.api.dto.userInfoDto;
import com.peisia.api.dto.lolDto.lol;

public interface LolService {
	public userInfoDto searchUser(String search);
	public  lol UserInfo(SearchDto search);
	
}
