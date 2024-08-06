package com.eagles.mybatis.mapper;

import com.eagles.mybatis.pojo.User;
import com.eagles.mybatis.provider.UserProvider;
import org.apache.ibatis.annotations.*;

import javax.annotation.processing.Generated;
import java.util.HashMap;
import java.util.List;

public interface UserMapper {

    List<User> getUserList();


    @Select("select * from tb_user where id = #{id}")
    User getUserById(Integer id);

    @Update("update tb_user set username = #{username},address = #{address} where id = #{id}")
    Integer updateUser(User user);


    @Insert("insert into tb_user(username, address) values (#{username},#{address})")
    
    Integer insertUser(User user);

    @Delete("delete from tb_user where id = #{id}")
    Integer deleteUserById(Integer id);
    
    @Select("select * from tb_user where username like '%${likeName}%'")
    User selectUserByLikeName(String likeName);

    @Select("select * from tb_user where username like '%${likeName}%'")
    User selectUserByMap(HashMap<String, String> map);

    @Select("select * from tb_user limit #{startIndex},#{pageSize}")
    List<User> limitUserList(HashMap<String, Object> map);


    @Insert("insert into tb_user(username,address) values(#{username},#{address})")
    @SelectKey(statement = "select last_insert_id()", keyColumn = "id",keyProperty = "id", before = false, resultType = int.class)
    Integer insertUserGetId(User user);


    @SelectProvider(value = UserProvider.class,method = "getList")
    List<User> getList(HashMap<String, Object> map);

}
