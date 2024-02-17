package com.cuiyq.service;

import com.cuiyq.dao.EmpDao;
import com.cuiyq.domain.Emp;
import com.cuiyq.domain.Result;

import java.util.List;

/**
 * @author Cuiyq
 * @version 1.0
 * describe：
 */
public class EmpService {
    private EmpDao empDao = new EmpDao();

    public List<Emp> list() {
        List<Emp> list = empDao.list();

//        根据返回的数据进行更改
        for (Emp emp : list) {
            if ("1".equals(emp.getGender())) {
                emp.setGender("男");
            } else {
                emp.setGender("女");
            }

            if ("1".equals(emp.getJob())) {
                emp.setJob("java");
            } else if ("2".equals(emp.getJob())) {
                emp.setJob("php");
            } else if ("3".equals(emp.getJob())) {
                emp.setJob("html");
            }
        }

        return list;
    }
}
