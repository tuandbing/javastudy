package com.eagles.day32project.controller;

import com.eagles.day32project.pojo.Area;
import com.eagles.day32project.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("area")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @RequestMapping("getAreaList")
    @ResponseBody
    public List<Area> getAreaList(){

        return areaService.getAreaList();

    }

}
