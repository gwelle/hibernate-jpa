package org.eclipse.main;

import java.util.List;

import org.eclipse.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AppDelete {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration().configure();
		
		configuration.addAnnotatedClass(User.class);
		
		try(SessionFactory sessionFactory = configuration.buildSessionFactory()){
			
			try(Session session = sessionFactory.openSession()){
        	
        	try{
        		
        		User user = session.get(User.class, 18);
        		
        		session.delete(user);
        		session.flush();
  
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
