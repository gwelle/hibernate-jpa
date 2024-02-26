package org.eclipse.main;

import org.eclipse.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration().configure();
				
		try(SessionFactory sessionFactory = configuration.buildSessionFactory()){
			
			try(Session session = sessionFactory.openSession()){
        	
        	Transaction transaction = null;
        		
        	try{
        		
        		User user = new User("appLoad.app@gmail.com","app","USER");
        		transaction = session.beginTransaction();
        		session.persist(user);
        		transaction.commit();
        		System.out.println("Success");
        	}
        		
        		catch (Exception e) {
        			e.printStackTrace();
        			if(transaction != null) transaction.rollback();
				}
        	}
			
		}
        
        catch(NoClassDefFoundError e) {
        	e.printStackTrace();
        }

	}

}
