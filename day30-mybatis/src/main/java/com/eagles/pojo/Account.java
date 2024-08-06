package com.eagles.pojo;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Data
public class Account implements Serializable {

    private Integer aid;

    private double money;

    private String desc;

    private Integer uid;

    private User user;  // 处理一对一

}
