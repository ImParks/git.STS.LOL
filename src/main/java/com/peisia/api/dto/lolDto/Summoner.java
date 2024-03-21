package com.peisia.api.dto.lolDto;

import lombok.Data;

@Data
public class Summoner {

	public String id;
	public String accountId;
	public String puuid;
	public String name;
	public Integer profileIconId;
	public Long revisionDate;
	public Integer summonerLevel;

	
}
