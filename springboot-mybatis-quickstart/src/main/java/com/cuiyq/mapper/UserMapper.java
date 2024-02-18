package com.cuiyq.mapper;

import com.cuiyq.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Cuiyq
 * @version 1.0
 * describe：
 */

@Mapper
public interface UserMapper {


    @Select("select id, name, age, gender, phone from user")
    public List<User> selectAll();
}
