package org.eclipse.main.jpa.advanced;

import org.eclipse.enums.Gender;
import org.eclipse.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AppCreate {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(User.class);
				
		try(SessionFactory sessionFactory = configuration.buildSessionFactory()){
			try(Session session = sessionFactory.openSession()){     		
	        	try{
	        		
	        		User user = new User("imoni.rombaa@gmail.com","password","USER",Gender.FEMME);
	        		session.persist(user);
	        		session.flush();
	        		System.out.println(user.getEmail());
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