package com.peisia.api.dto;

import lombok.Data;

@Data
public class SearchDto {
	private String gameNameTag = "";
	private String userName = "";
	private String userTag = "";
	private String puuid;
	private int start = 0;
	private int count = 1;
}
