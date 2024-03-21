
package com.peisia.api.dto.lolDto.MatchDto;

import java.util.List;

import lombok.Data;

@Data
public class Info {

	private String endOfGameResult;
	private Long gameCreation;
	private Integer gameDuration;
    private Long gameEndTimestamp;
    private Long gameId;
    private String gameMode;
    private String gameName;
    private Long gameStartTimestamp;
    private String gameType;
    private String gameVersion;
    private Integer mapId;
    private List<Object> participants;
    private String platformId;
    private Integer queueId;
    private List<Team> teams;
    private String tournamentCode;

}
