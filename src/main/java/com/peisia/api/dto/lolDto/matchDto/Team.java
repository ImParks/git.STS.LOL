
package com.peisia.api.dto.lolDto.matchDto;

import java.util.List;

import lombok.Data;

@Data
public class Team {

    private List<Ban> bans;
    private Objectives objectives;
    private Integer teamId;
    private Boolean win;

}
