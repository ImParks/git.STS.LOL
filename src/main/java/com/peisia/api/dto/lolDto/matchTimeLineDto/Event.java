
package com.peisia.api.dto.lolDto.matchTimeLineDto;

import lombok.Data;

@Data
public class Event {

    private Long realTimestamp;
    private Integer timestamp;
    private String type;

}
