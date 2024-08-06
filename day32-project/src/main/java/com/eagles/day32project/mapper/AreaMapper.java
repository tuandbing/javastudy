package com.eagles.day32project.mapper;

import com.eagles.day32project.pojo.Area;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AreaMapper {

    /**
     * 获取所有地区
     */
    List<Area> getAreaList();

    /**
     * 根据id查找地区
     */
    Area getAreaById(Integer id);

    Area getAreaByName(String likeArea);
}
