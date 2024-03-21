
package com.peisia.api.dto.lolDto.MatchTimeLineDto;

import java.util.List;

import lombok.Data;

@Data
public class Frame {

    private List<Event> events;
    private ParticipantFrames participantFrames;
    private Integer timestamp;
    
}
