
package com.peisia.api.dto.lolDto.singleChampionDto;

import java.util.List;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Champion {

    public String id;
    public String key;
    public String name;
    public String title;
    public Image image;
    public List<Skin> skins;
    public String lore;
    public String blurb;
    public List<String> allytips;
    public List<String> enemytips;
    public List<String> tags;
    public String partype;
    public Info info;
    public Stats stats;
    public List<Spell> spells;
    public Passive passive;
    public List<Object> recommended;

}
