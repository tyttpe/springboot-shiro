package com.mapper;

import com.dao.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "name",column = "name"),
        @Result(property = "password",column = "password"),
        @Result(property = "perms",column = "perms")
    })
    @Select("select id,name,password from t_user where name = #{name}")
    public User findByName(String name);

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "password",column = "password"),
            @Result(property = "perms",column = "perms")
    })
    @Select("select * from t_user where id = #{id   }")
    public User findById(Integer id);
}
