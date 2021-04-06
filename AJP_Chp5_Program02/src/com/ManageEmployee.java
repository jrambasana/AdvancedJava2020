package com;

import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class ManageEmployee {
private static SessionFactory factory; 
public static void main(String[] args) {

  try {
     factory = new AnnotationConfiguration().configure().addPackage("com").addAnnotatedClass(Employee.class).buildSessionFactory();
  } catch (HibernateException ex) { 
     System.err.println("Failed to create sessionFactory object." + ex);
     throw new ExceptionInInitializerError(ex); 
  }

  ManageEmployee ME = new ManageEmployee();

  /* Add few employee records in database */
  Integer empID1 = ME.addEmployee("Deep", "Sangani", 100000);
  Integer empID2 = ME.addEmployee("Priyank", "Shah", 500000);
  Integer empID3 = ME.addEmployee("Rusita", "Pilojpara", 700000);

  /* List down all the employees */
  System.out.println("After adding three employees");
  ME.listEmployees();

  System.out.println("********************************************");

  /* Update employee's records */
  System.out.println("After updating Employee no: "+empID1);
  ME.updateEmployee(empID1, 500000);
  ME.listEmployees();

  System.out.println("********************************************");

  /* Delete an employee from the database */
  System.out.println("After deleting Employee no: "+empID2);
  ME.deleteEmployee(empID2);
  ME.listEmployees();
}

   /* Method to CREATE an employee in the database */
public Integer addEmployee(String fname, String lname, int salary){
   Session session = factory.openSession();
   Transaction tx = null;
   Integer employeeID = null;
   try {
      tx = session.beginTransaction();
      Employee employee = new Employee();
      employee.setFirstName(fname);
      employee.setLastName(lname);
      employee.setSalary(salary);
      employeeID = (Integer) session.save(employee); 
      tx.commit();
   } catch (HibernateException e) {
      if (tx!=null) {
           tx.rollback();
       }
      e.printStackTrace(); 
   } finally {
      session.close(); 
   }
   return employeeID;
}
   
   /* Method to  READ all the employees */
public void listEmployees( ){
   Session session = factory.openSession();
   Transaction tx = null;

   try {
      tx = session.beginTransaction();
      List employees = session.createQuery("FROM Employee").list(); 
      for (Iterator itr = employees.iterator(); itr.hasNext();){
         Employee employee = (Employee) itr.next(); 
         System.out.print("Employee ID :" + employee.getId());
         System.out.print(" First Name: " + employee.getFirstName()); 
         System.out.print("  Last Name: " + employee.getLastName()); 
         System.out.println("  Salary: " + employee.getSalary()); 
      }
      tx.commit();
   } catch (HibernateException e) {
      if (tx!=null) {
           tx.rollback();
       }
      e.printStackTrace(); 
   } finally {
      session.close(); 
   }
}


   /* Method to UPDATE salary for an employee */
public void updateEmployee(Integer EmployeeID, int salary ){
Session session = factory.openSession();
Transaction tx = null;
try {
   tx = session.beginTransaction();
   Employee employee = (Employee)session.get(Employee.class, EmployeeID); 
   employee.setSalary( salary );
   session.update(employee); 
   tx.commit();
} catch (HibernateException e) {
   if (tx!=null) tx.rollback();
   e.printStackTrace(); 
} finally {
   session.close(); 
}
}

/* Method to DELETE an employee from the records */
public void deleteEmployee(Integer EmployeeID){
Session session = factory.openSession();
Transaction tx = null;
try {
   tx = session.beginTransaction();
   Employee employee = (Employee)session.get(Employee.class, EmployeeID); 
   session.delete(employee); 
   tx.commit();
} catch (HibernateException e) {
   if (tx!=null) tx.rollback();
   e.printStackTrace(); 
} finally {
   session.close(); 
}
}
}
    

