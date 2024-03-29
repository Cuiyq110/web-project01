package com.cuiyq.controller;

import com.cuiyq.domain.Emp;
import com.cuiyq.domain.Result;
import com.cuiyq.service.EmpService;
import com.cuiyq.service.impl.EmpServiceB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Cuiyq
 * @version 1.0
 * describe：
 */
@RestController
public class EmpController {

//    @Qualifier("empServiceB")
//    @Autowired
    @Resource(name = "empServiceA")
    private EmpService empService1;

    @RequestMapping("/listEmp")
    public Result ResultList() {
        List<Emp> empList = empService1.list();
        return Result.success(empList);
    }

//    没有进行拆分的方法

//    @RequestMapping("/listEmp")
//    public Result ResultList() {
//
//        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
//        List<Emp> empList = XmlParserUtils.parse(file, Emp.class);
//
////        对数据进行转换处理
//        for (Emp emp : empList) {
//            if ("1".equals(emp.getGender())) {
//                emp.setGender("男");
//            } else {
//                emp.setGender("女");
//            }
//
//            if ("1".equals(emp.getJob())) {
//                emp.setJob("讲师");
//            } else if ("2".equals(emp.getJob())){
//                emp.setJob("班主任");
//            } else if ("3".equals(emp.getJob())){
//                emp.setJob("就业指导");
//            }
//        }
//
//        return Result.success(empList);
//    }
}
