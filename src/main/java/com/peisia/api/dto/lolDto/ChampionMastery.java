package com.peisia.api.dto.lolDto;

import lombok.Data;

@Data
public class ChampionMastery {
	private String puuid;
	private Integer championId;
	private Integer championLevel;
	private Integer championPoints;
	private Long lastPlayTime;
	private Integer championPointsSinceLastLevel;
	private Integer championPointsUntilNextLevel;
	private Boolean chestGranted;
	private Integer tokensEarned;
	private String summonerId;
	
}

