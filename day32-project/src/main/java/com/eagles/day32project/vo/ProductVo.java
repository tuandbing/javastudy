package com.eagles.day32project.vo;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class ProductVo {

    // 当前页码
    private String currentPage;

    // 名称模糊查询
    private String likeName;

    // 产地模糊查询
    private String likeArea;

    // 上架区间模糊查询
    private String upTimeStart;
    private String upTimeEnd;


}
