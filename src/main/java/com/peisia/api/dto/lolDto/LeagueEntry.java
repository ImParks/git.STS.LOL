package com.peisia.api.dto.lolDto;

import lombok.Data;

@Data
public class LeagueEntry {

private String leagueId;
private String queueType;
private String tier;
private String rank;
private String summonerId;
private String summonerName;
private Integer leaguePoints;
private Integer wins;
private Integer losses;
private Boolean veteran;
private Boolean inactive;
private Boolean freshBlood;
private Boolean hotStreak;

}