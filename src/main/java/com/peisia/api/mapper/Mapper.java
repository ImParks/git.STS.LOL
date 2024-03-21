package com.peisia.api.mapper;

import com.peisia.api.dto.userInfoDto;
import com.peisia.api.dto.lolDto.lol;

public interface Mapper {

public userInfoDto userInfoSelect(String name);
public void userInfoInsert(lol userInfo);
public void userInfoUpdate(userInfoDto userInfo);
}
