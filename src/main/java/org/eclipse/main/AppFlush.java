package org.eclipse.main;

import org.eclipse.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AppFlush {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration().configure();
		
		configuration.addAnnotatedClass(User.class);
		
		try(SessionFactory sessionFactory = configuration.buildSessionFactory()){
			
			try(Session session = sessionFactory.openSession()){
        	
        	try{
        		
        		User user = new User("jesus.jesus.com","christ","USER");
        		session.persist(user);
        		session.flush();
        		System.out.println("Success");
        	}
        		
        		catch (Exception e) {
        			e.printStackTrace();
				}
        	}
			
		}
        
        catch(NoClassDefFoundError e) {
        	e.printStackTrace();
        }

	}

}
