package hibernate01;  

import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
 
public class CustomerDAO {

static SessionFactory factory;

public static int register(Customer u){  
int i=0;  
StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
factory = meta.getSessionFactoryBuilder().build();
Session session = factory.openSession();
Transaction t = session.beginTransaction(); 
i=(Integer)session.save(u);  
t.commit();  
session.close();  
return i;   
}  

public static List listCustomers( )
{
   StandardServiceRegistry ssr = 
       new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
   Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
   factory = meta.getSessionFactoryBuilder().build();
   Session session = factory.openSession();
   Transaction tx = null;
   List customers = null;
   try {
      tx = session.beginTransaction();
      customers = session.createQuery("FROM Customer").list(); 
      tx.commit();
   } catch (HibernateException e) {
      if (tx!=null) {
           tx.rollback();
       }
      e.printStackTrace(); 
   } finally {
      session.close(); 
   }
   return customers;
}
}  