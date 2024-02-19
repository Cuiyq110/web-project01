package com.cuiyq.mapper;

import com.cuiyq.domain.Emp;
import org.apache.ibatis.annotations.*;

/**
 * @author Cuiyq
 * @version 1.0
 * describe：
 */
@Mapper
public interface EmpMapper {

    /**
     * 更新
     * @param emp
     * @return
     */

    @Update("update emp set username=#{username}, name=#{name}, gender=#{gender}, image=#{image}, job=#{job}, entrydate=#{entrydate}, dept_id=#{deptId},update_time=#{updateTime} where id=#{id}")
    public int update(Emp emp);

    /**
     * 查询
     * @param id 根据id查询单条记录
     * @return
     */
//    第二种方式
//    @Results(
//            {@Result(column = "dept_id", property = "deptId"),
//            @Result(column = "create_time", property = "createTime"),
//            @Result(column = "update_time", property = "updateTime")
//            })

    @Select("select * from emp where id=#{id}")
    Emp GetElementById(int id);

    /**
     * 插入
     *
     * @param emp
     * @return
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) values" +
            " (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    int Insert(Emp emp);

    /**
     * 删除
     *
     * @param id 根据id删除
     * @return
     */
    @Delete("delete from emp where id=#{id}")
    int DelById(int id);
}
