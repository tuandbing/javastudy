package com.eagles.day32project.service.impl;

import com.eagles.day32project.mapper.ProductMapper;
import com.eagles.day32project.pojo.Product;
import com.eagles.day32project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {

    private Date date = new Date();

    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getProductList(HashMap<String, Object> map) {
        return mapper.getProductList(map);
    }

    @Override
    public Integer getCount(HashMap<String, Object> map) {
        return mapper.getCount(map);
    }

    @Override
    public Product getProductById(Integer id) {

        return mapper.getProductById(id);
    }

    @Override
    public Integer updateProduct(HashMap<String,Object> map) {
        return mapper.updateProduct(map);
    }

    @Override
    public Integer insertProduct(HashMap<String,Object> map) {
        map.put("date",date);
        return mapper.insertProduct(map);
    }

    @Override
    public Integer deleteProduct(String ids) {
        return mapper.deleteProduct(ids);
    }
}
