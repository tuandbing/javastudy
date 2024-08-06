package com.eagles.day32project.mapper;

import com.eagles.day32project.pojo.Business;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface BusinessMapper {

    /**
     * 获取所有商家信息
     */
    List<Business> getBusinessList(HashMap<String,Object> map);

    /**
     * 对商家进行更新
     */
    Integer updateBusiness(Business business);

    /**
     * 添加商家
     */
    Integer insertBusiness(Business business);

    /**
     * 删除商家(通过id)
     */
    Integer deleteBusiness(Integer id);

    /**
     * 商家登录校验
     */
    Business login(Business business);

    /**
     * 通过名称查找商家
     */
    Business getBusinessByName(String username);

    /**
     * 通过id查找商家
     */
    Business getBusinessById(Integer id);

}
