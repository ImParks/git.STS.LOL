package com.peisia.api.dto.lolDto;

import java.util.List;

import com.peisia.api.dto.lolDto.matchDto.Match;

import lombok.Data;

@Data
public class lol {

	private Account account; // 계정 puuid
	private List<ChampionMastery> championMastery; // 챔피언 숙련도
	private List<LeagueEntry> leagueEntry;// 랭크
	private Summoner summoner; // 계정 인포
	private List<String> matchID; // 매치 아이디
	private List<Match> match;
	
}
