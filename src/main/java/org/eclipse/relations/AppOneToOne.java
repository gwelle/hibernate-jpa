package org.eclipse.relations;

import org.eclipse.model.Address;
import org.eclipse.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AppOneToOne {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration().configure();
				
		try(SessionFactory sessionFactory = configuration.buildSessionFactory()){
			
			try(Session session = sessionFactory.openSession()){
        	        		
	        	try{
	        		
	        		User user = session.get(User.class, 1);
	        		Address address = new Address("Paris", "75001", "Paris");
	        		user.addAddress(address);
	        		session.persist(user);
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