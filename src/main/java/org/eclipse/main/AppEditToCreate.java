package org.eclipse.main;

import java.util.List;

import org.eclipse.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AppEditToCreate {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration().configure();
		
		configuration.addAnnotatedClass(User.class);
		
		try(SessionFactory sessionFactory = configuration.buildSessionFactory()){
			
			try(Session session = sessionFactory.openSession()){
        	
        	try{
        		
        		User user = new User();
        		user.setEmail("denzel.washington@gmail.com");
        		user.setId(1);
        		user.setPassword("denzel");
        		user.setRole("ADMIN");
        		session.save(user);
  
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
