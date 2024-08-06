package com.eagles.day32project.service;

import com.eagles.day32project.pojo.Area;

import java.util.List;

public interface AreaService {

    List<Area> getAreaList();

    Area getAreaById(Integer id);

    Area getAreaByName(String likeArea);
}
