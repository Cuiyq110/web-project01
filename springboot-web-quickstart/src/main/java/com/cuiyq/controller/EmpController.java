package com.cuiyq.controller;

import com.cuiyq.domain.Emp;
import com.cuiyq.domain.Result;
import com.cuiyq.utils.XmlParserUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Cuiyq
 * @version 1.0
 * describe：
 */
@RestController
public class EmpController {


    @RequestMapping("/listEmp")
    public Result ResultList() {

        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        List<Emp> empList = XmlParserUtils.parse(file, Emp.class);

//        对数据进行转换处理
        for (Emp emp : empList) {
            if ("1".equals(emp.getGender())) {
                emp.setGender("男");
            } else {
                emp.setGender("女");
            }

            if ("1".equals(emp.getJob())) {
                emp.setJob("讲师");
            } else if ("2".equals(emp.getJob())){
                emp.setJob("班主任");
            } else if ("3".equals(emp.getJob())){
                emp.setJob("就业指导");
            }
        }

        return Result.success(empList);
    }
}
