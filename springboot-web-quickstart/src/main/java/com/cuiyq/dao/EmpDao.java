package com.cuiyq.dao;

import com.cuiyq.domain.Emp;
import com.cuiyq.domain.Result;
import com.cuiyq.utils.XmlParserUtils;

import java.util.List;

/**
 * @author Cuiyq
 * @version 1.0
 * describe：
 */
public class EmpDao extends BasicDao<Emp>{

   public List<Emp> list(){
       String file =  this.getClass().getClassLoader().getResource("emp.xml").getFile();
       List<Emp> parse = XmlParserUtils.parse(file, Emp.class);
       return parse;
   }
}
