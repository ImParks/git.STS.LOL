
package com.peisia.api.dto.lolDto.settingDto;

import java.util.List;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Spell {

    public String id;
    public String name;
    public String description;
    public String tooltip;
    public Leveltip leveltip;
    public Integer maxrank;
    public List<Integer> cooldown;
    public String cooldownBurn;
    public List<Integer> cost;
    public String costBurn;
    public Datavalues datavalues;
    public List<Object> effect;
    public List<Object> effectBurn;
    public List<Object> vars;
    public String costType;
    public String maxammo;
    public List<Integer> range;
    public String rangeBurn;
    public Image__1 image;
    public String resource;

}
