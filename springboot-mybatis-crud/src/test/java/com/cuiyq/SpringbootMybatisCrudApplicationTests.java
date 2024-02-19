package com.cuiyq;

import com.cuiyq.domain.Emp;
import com.cuiyq.mapper.EmpMapper;
import org.apache.catalina.util.ToStringUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class SpringbootMybatisCrudApplicationTests {

    @Autowired
    private EmpMapper mapper;


//    条件查询测试
    @Test
    void testList() {

//        List<Emp> list = mapper.list("张", (short)1, LocalDate.of(2010,1,1), LocalDate.of(2020,1,1));
        List<Emp> list = mapper.list("张", null,null,null);
        System.out.println(list);
    }

//   删除数据测试
    @Test
    void contextLoads() {
        if (mapper.DelById(16) > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("未对数据库进行操作");
        }
    }

//    测试增加数据
    @Test
    void testInsert() {
        Emp emp = new Emp();
        emp.setUsername("cuiyq2");
        emp.setPassword("123456");
        emp.setName("cuiyq2");
        emp.setGender((short) 1);
        emp.setImage("123456");
        emp.setJob((short) 1);
        emp.setEntrydate(LocalDate.of(2000, 1, 1));
        emp.setDeptId(1);
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        if (mapper.Insert(emp) > 0) {
            System.out.println("添加成功");
            System.out.println(emp.getId());
        } else {
            System.out.println("添加失败");
        }

    }

//    根据id查对象测试
    @Test
    void testSelectElementById() {
        Emp emp = mapper.GetElementById(18);
        System.out.println(emp);
    }

//    更新测试
    @Test
    void testUpdate() {
        Emp emp = new Emp();
        emp.setId(18);
        emp.setUsername("啊嘞");
        emp.setPassword("123456");
        emp.setName("啊嘞");
        emp.setGender((short) 1);
        emp.setImage("123456");
        emp.setJob((short) 1);
        emp.setEntrydate(LocalDate.of(2000, 1, 1));
        emp.setDeptId(1);
        emp.setUpdateTime(LocalDateTime.now());
        if (mapper.update(emp) > 0) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }
    }

//    动态更新员工
    @Test
    public void testUpdate2() {
        Emp emp = new Emp();
        emp.setId(20);
//        emp.setUsername("jack");
        emp.setPassword("123456");
        emp.setName("啊嘞1");
        emp.setGender((short) 1);
//        emp.setImage("123456");
//        emp.setJob((short) 1);
//        emp.setEntrydate(LocalDate.of(2000, 1, 1));
//        emp.setDeptId(1);
//        emp.setUpdateTime(LocalDateTime.now());
        if (mapper.update2(emp) > 0) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }
    }


}
