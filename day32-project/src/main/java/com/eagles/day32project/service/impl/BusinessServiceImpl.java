package com.eagles.day32project.service.impl;

import com.eagles.day32project.mapper.BusinessMapper;
import com.eagles.day32project.pojo.Business;
import com.eagles.day32project.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private BusinessMapper mapper;

    @Autowired
    private RedisTemplate redisTemplate;

    private static Integer count = 0;

    @Override
    public List<Business> getBusinessList(HashMap<String, Object> map) {
        redisFlush(count++);
        return this.getList();
    }

    @Override
    public Integer updateBusiness(Business business) {
        Integer num = mapper.updateBusiness(business);
        if(num == 1){
            redisFlush(1);
        }
        return num;
    }

    @Override
    public Integer insertBusiness(Business business) {
        Integer num = mapper.insertBusiness(business);
        if(num == 1){
            redisFlush(1);
        }
        return num;
    }

    @Override
    public Integer deleteBusiness(Integer id) {
        Integer num = mapper.deleteBusiness(id);
        if(num == 1){
            redisFlush(1);
        }
        return num;
    }

    @Override
    public Business login(Business business) {
        redisFlush(count++);
        for (Business business1 : this.getList()) {
            if(business.getUsername().equals(business1.getUsername()) && business.getPassword().equals(business1.getPassword())){
                return business1;
            }
        }
        return null;
    }

    @Override
    public Business getBusinessByName(String username) {
        redisFlush(count++);
        for (Business business : this.getList()) {
            if(business.getUsername().equals(username)){
                return business;
            }
        }
        return null;
    }

    @Override
    public Business getBusinessById(Integer id) {
        redisFlush(count++);
        for (Business business : this.getList()) {
            if(business.getId().equals(id)){
                return business;
            }
        }
        return null;
    }

    public void redisFlush(Integer flag){

        // flag = 1 说明进行了增删改的操作或者为第一次查询，需要进行更新
        if(flag == 1){
            redisTemplate.setEnableDefaultSerializer(true);

            redisTemplate.setKeySerializer(new StringRedisSerializer());

            redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());

            redisTemplate.setHashValueSerializer(new StringRedisSerializer());

            redisTemplate.delete(redisTemplate.keys("businessList"));

            HashMap<String, Object> map = new HashMap<>();

            for (Business business : mapper.getBusinessList(map)) {
                redisTemplate.boundListOps("businessList").rightPush(business);
            }
        }
    }

    public List<Business> getList(){
        return redisTemplate.boundListOps("businessList").range(0,-1);
    }
}
