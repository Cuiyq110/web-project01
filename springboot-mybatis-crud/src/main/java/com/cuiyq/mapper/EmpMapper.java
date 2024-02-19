package com.cuiyq.mapper;

import com.cuiyq.domain.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

/**
 * @author Cuiyq
 * @version 1.0
 * describe：
 */
@Mapper
public interface EmpMapper {

    /**
     * 插入
     * @param emp
     * @return
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) values" +
            " (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    int Insert(Emp emp);

    /**
     * 删除
     * @param id 根据id删除
     * @return
     */
    @Delete("delete from emp where id=#{id}")
    int DelById(int id);
}
