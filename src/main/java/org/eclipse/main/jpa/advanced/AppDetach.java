package org.eclipse.main.jpa.advanced;

import org.eclipse.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AppDetach {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(User.class);
				
		try(SessionFactory sessionFactory = configuration.buildSessionFactory()){
			try(Session session = sessionFactory.openSession()){     		
	        	try{
	        		
	        		User user = session.find(User.class, 6);
	        		System.out.println(user.getEmail());
	        		
	        		user.setEmail("jolie.moreau@france.com");
	        		session.detach(user);
	        		session.flush();
	        		
	        		User user1 = session.find(User.class, 6);
	        		System.out.println(user1.getEmail());
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