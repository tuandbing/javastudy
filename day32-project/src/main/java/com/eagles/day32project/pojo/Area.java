package com.eagles.day32project.pojo;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@EqualsAndHashCode
public class Area implements Serializable {

    private Integer id;

    private String areaName;

}
