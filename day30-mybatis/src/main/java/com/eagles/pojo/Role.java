package com.eagles.pojo;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Data
public class Role {
    private Integer rid;

    private String roleName;

    private List<User> users;
}
