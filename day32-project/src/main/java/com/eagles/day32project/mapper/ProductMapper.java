package com.eagles.day32project.mapper;

import com.eagles.day32project.pojo.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface ProductMapper {

    /**
     * 获取当前商家的所有商品与公开的商品
     */
    public List<Product> getProductList(HashMap<String, Object> map);

    /**
     * 获取当前商家所生产的产品和其它商家指定公开的产品的总数目
     */
    Integer getCount(HashMap<String,Object> map);


    /**
     * 根据id查询指定商品
     */
    Product getProductById(Integer id);

    /**
     * 对商品进行更新
     */
    Integer updateProduct(HashMap<String,Object> map);


    /**
     * 添加商品
     */
    Integer insertProduct(HashMap<String,Object> map);

    /**
     * 删除商品
     */
    Integer deleteProduct(String ids);
}
