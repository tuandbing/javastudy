package com.eagles.day32project.pojo;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@EqualsAndHashCode
public class Product implements Serializable {

    private Integer id;

    // 产品名称
    private String productName;

    // 产品特色
    private String feature;

    // 产地
    private Area area;

    // 规格
    private String weight;

    // 单价
    private Double price;

    // 当前商家
    private Business business;

    // 发布时间
    private Date date;

    // 访问权限
    private Integer power;


}
