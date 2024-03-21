
package com.peisia.api.dto.lolDto.MatchTimeLineDto;

import java.util.List;

import lombok.Data;

@Data
public class Info {

    private String endOfGameResult;
    private Integer frameInterval;
    private List<Frame> frames;
    private Long gameId;
    private List<Participant> participants;

}
