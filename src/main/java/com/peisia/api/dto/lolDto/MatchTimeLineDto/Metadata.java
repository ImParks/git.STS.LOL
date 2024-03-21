
package com.peisia.api.dto.lolDto.MatchTimeLineDto;

import java.util.List;

import lombok.Data;

@Data
public class Metadata {

    private String dataVersion;
    private String matchId;
    private List<String> participants;

}
