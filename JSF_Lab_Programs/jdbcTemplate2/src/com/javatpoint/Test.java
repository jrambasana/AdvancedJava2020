package com.javatpoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Test {

public static void main(String[] args) {
    ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");

    EmployeeDao dao=(EmployeeDao)ctx.getBean("edao");
    
    Employee e = new Employee(101,"Lucky",35000);
    int status = dao.saveEmployee(e);
    System.out.println(status);
    
    e = new Employee(102,"Ducky",300);
    status = dao.saveEmployee(e);
    System.out.println(status);
    

    status=dao.updateEmployee(e);
    System.out.println(status);
    

//    e=new Employee();
//    e.setId(101);
//    status=dao.deleteEmployee(e);
//    System.out.println(status);
}
}
