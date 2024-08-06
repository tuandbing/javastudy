package com.eagles.mybatis.provider;


import org.apache.ibatis.jdbc.SQL;

import java.util.HashMap;


public class UserProvider {

    public String getList(HashMap<String, Object> map){

        return new SQL(){
            {
                SELECT("*");
                FROM("tb_user");
                if(map.get("likeName") != null && !map.get("likeName").equals("")){

                    WHERE("username like '%${likeName}%'");

                }
                if(map.get("indexStart") != null && map.get("pageSize") != null){

                    LIMIT("#{indexStart},#{pageSize}");

                }
            }
        }.toString();

    }

}
