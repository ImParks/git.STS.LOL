
package com.peisia.api.dto.lolDto.matchTimeLineDto;

import lombok.Data;

@Data
public class DamageStats {

    private Integer magicDamageDone;
    private Integer magicDamageDoneToChampions;
    private Integer magicDamageTaken;
    private Integer physicalDamageDone;
    private Integer physicalDamageDoneToChampions;
    private Integer physicalDamageTaken;
    private Integer totalDamageDone;
    private Integer totalDamageDoneToChampions;
    private Integer totalDamageTaken;
    private Integer trueDamageDone;
    private Integer trueDamageDoneToChampions;
    private Integer trueDamageTaken;

}
