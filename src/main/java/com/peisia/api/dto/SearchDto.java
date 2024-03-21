package com.peisia.api.dto;

import lombok.Data;

@Data
public class SearchDto {
private String gameNameTag = "";
 private String userName="";
 private String userTag="";
 private int page=0;
}
