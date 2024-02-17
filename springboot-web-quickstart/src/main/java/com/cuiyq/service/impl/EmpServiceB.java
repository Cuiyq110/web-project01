package com.cuiyq.service.impl;

import com.cuiyq.dao.impl.EmpDao;
import com.cuiyq.domain.Emp;
import com.cuiyq.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Cuiyq
 * @version 1.0
 * describe：
 */
@Service
public class EmpServiceB implements EmpService {
    @Autowired
    private EmpDao empDao;

    @Override
    public List<Emp> list() {
        List<Emp> list = empDao.list();

//        根据返回的数据进行更改
        for (Emp emp : list) {
            if ("1".equals(emp.getGender())) {
                emp.setGender("男士");
            } else {
                emp.setGender("女士");
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
