package com.cuiyq;

import com.cuiyq.domain.Emp;
import com.cuiyq.mapper.EmpMapper;
import org.apache.catalina.util.ToStringUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
class SpringbootMybatisCrudApplicationTests {

    @Autowired
    private EmpMapper mapper;
    @Test
    void contextLoads() {
        if (mapper.DelById(16) > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("未对数据库进行操作");
        }
    }

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

    @Test
    void testSelectElementById() {
        Emp emp = mapper.GetElementById(18);
        System.out.println(emp);
    }

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

}
