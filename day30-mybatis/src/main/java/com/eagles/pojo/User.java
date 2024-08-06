package com.eagles.pojo;

import lombok.*;
import lombok.experimental.NonFinal;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Data
public class User implements Serializable {

    private Integer id;

    private String name;

    private String password;

    private Integer age;

    private String address;

    List<Account> accounts;

}
