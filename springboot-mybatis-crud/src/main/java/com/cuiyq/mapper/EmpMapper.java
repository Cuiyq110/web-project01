package com.cuiyq.mapper;

import com.cuiyq.domain.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Cuiyq
 * @version 1.0
 * describe：
 */
@Mapper
public interface EmpMapper {


//    使用foreach进行批量删除
    public int deletesByIds(@Param("ids") List<Integer> ids);

//   使用xml映射进行动态sql更新
    public int update2(Emp emp);

//    使用xml映射方式进行对数据的查询操作
    public List<Emp> list(@Param("name") String name, @Param("gender") Short gender, @Param("begin")LocalDate begin, @Param("end")LocalDate end);

//    条件查询
//    @Select("select id, username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time" +
//            " from emp" +
//            " where name like concat('%',#{name},'%') and gender= #{gender} and entrydate between #{begin} and #{end}" +
//            " order by update_time desc")
//    public List<Emp> list(@Param("name") String name, @Param("gender") Short gender, @Param("begin")LocalDate begin, @Param("end")LocalDate end);
//    public List<Emp> list( String name,  Short gender, LocalDate begin, LocalDate end);

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
    @Results(
            {@Result(column = "dept_id", property = "deptId"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
            })

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
