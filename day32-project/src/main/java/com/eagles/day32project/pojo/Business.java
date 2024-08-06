package com.eagles.day32project.pojo;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@EqualsAndHashCode
public class Business implements Serializable {

    private Integer id;

    private String username;

    private String password;

    private String phone;

    private String address;

    private List<Product> productList;

    public Business(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
