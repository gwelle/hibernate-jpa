package org.eclipse.main;

import org.eclipse.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AppLoad {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration().configure();
		
		configuration.addAnnotatedClass(User.class);
		
		try(SessionFactory sessionFactory = configuration.buildSessionFactory()){
			
			try(Session session = sessionFactory.openSession()){
        	
        	try{
        		
        		User user = session.byId(User.class).load(7);
        		System.out.println(user);
        		
        		User user2 = session.load(User.class, 1);
        		System.out.println(user2);
        		
        		User user3 = session.get(User.class, 1);
        		System.out.println(user3);
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
