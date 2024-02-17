package com.cuiyq.dao.impl;

import com.cuiyq.dao.BasicDao;
import com.cuiyq.domain.Emp;
import com.cuiyq.utils.XmlParserUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Cuiyq
 * @version 1.0
 * describe：
 */

@Repository
public class EmpDao extends BasicDao<Emp> implements com.cuiyq.dao.EmpDao {

   public List<Emp> list(){
       String file =  this.getClass().getClassLoader().getResource("emp.xml").getFile();
       List<Emp> parse = XmlParserUtils.parse(file, Emp.class);
       return parse;
   }
}
