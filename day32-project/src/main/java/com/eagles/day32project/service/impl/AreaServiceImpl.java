package com.eagles.day32project.service.impl;

import com.eagles.day32project.mapper.AreaMapper;
import com.eagles.day32project.pojo.Area;
import com.eagles.day32project.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaMapper mapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public List<Area> getAreaList() {

        List<Area> list;

        redisTemplate.setEnableDefaultSerializer(true);

        redisTemplate.setKeySerializer(new StringRedisSerializer());

        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());

        redisTemplate.setHashValueSerializer(new StringRedisSerializer());

        if(redisTemplate.boundListOps("areaList").size() > 0) {

            list = redisTemplate.boundListOps("areaList").range(0,-1);

        }else{
            list = mapper.getAreaList();
            for (Area area : list) {
                redisTemplate.boundListOps("areaList").rightPush(area);
            }
        }
        return list;
    }

    @Override
    public Area getAreaById(Integer id) {

        List<Area> list = redisTemplate.boundListOps("areaList").range(0,-1);

        for (Area area : list) {
            if(area.getId().equals(id)) {
                return area;
            }
        }
        return null;
    }

    @Override
    public Area getAreaByName(String likeArea) {
        List<Area> list = redisTemplate.boundListOps("areaList").range(0,-1);

        for (Area area : list) {
            if(area.getAreaName().equals(likeArea)) {
                return area;
            }
        }
        return null;
    }
}
