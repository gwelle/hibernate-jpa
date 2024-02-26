package org.eclipse.relations;

import org.eclipse.model.Address;
import org.eclipse.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.cfg.Configuration;

public class AppManyToOne {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration().configure();
				
		try(SessionFactory sessionFactory = configuration.buildSessionFactory()){
			
			try(Session session = sessionFactory.openSession()){
        	        		
	        	try{
	        		
	        		User user1 = session.get(User.class, 1);
	        		User user2 = session.get(User.class, 2);
	        		User user3 = session.get(User.class, 3);
	        		User user4 = session.get(User.class, 4);
	        		
	        		Address address1 = session.get(Address.class, 1);
	        		//Address address2 = new Address("Plantes", "75014", "Paris");
	        		Address address2 = session.get(Address.class, 2);
	        		Address address3 = session.get(Address.class, 3);
	        		
	        		//user1.setAdress(address3);
	        		
	        		//user2.setAdress(address3);
	        		
	        		//user3.setAdress(address2);
	        		
	        		//user4.setAdress(address1);
	        		
	        		session.persist(user1);
	        		session.persist(user2);
	        		session.persist(user3);
	        		session.persist(user4);
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