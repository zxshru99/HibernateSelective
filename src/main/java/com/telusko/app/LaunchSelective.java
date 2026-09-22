package com.telusko.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.telusko.model.Employee1;



public class LaunchSelective {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory sessionfactory=new Configuration().configure().addAnnotatedClass(Employee1.class).buildSessionFactory();
		Session session =null;
		Transaction transaction=null;
		Boolean flag=false;
		
		try {
			session=sessionfactory.openSession();
			transaction=session.beginTransaction();
			Employee1 emp=new Employee1();
			emp.setEid(2);
			emp.setEname("ayush");
		
			emp.setEage(23);
			session.persist(emp);
			flag=true;
			
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag==true) {
				transaction.commit();
				
			}
			else {
				transaction.rollback();
			}
			session.close();
			sessionfactory.close();
			
		}
		

	}

}
