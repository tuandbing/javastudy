package com.eagles.mybatis.pojo;


import lombok.*;
import org.apache.ibatis.annotations.ConstructorArgs;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class User {


    private Integer id;

    private String username;

    private String address;

}
