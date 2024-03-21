
package com.peisia.api.dto.lolDto.MatchTimeLineDto;

import lombok.Data;

@Data
public class Event {

    private Long realTimestamp;
    private Integer timestamp;
    private String type;

}
