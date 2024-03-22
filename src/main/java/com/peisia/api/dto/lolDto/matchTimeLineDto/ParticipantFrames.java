
package com.peisia.api.dto.lolDto.matchTimeLineDto;

import lombok.Data;

@Data
public class ParticipantFrames {

    private ChampionStats championStats;
    private Integer currentGold;
    private DamageStats damageStats;
    private Integer goldPerSecond;
    private Integer jungleMinionsKilled;
    private Integer level;
    private Integer minionsKilled;
    private Integer participantId;
    private Position position;
    private Integer timeEnemySpentControlled;
    private Integer totalGold;
    private Integer xp;

}
