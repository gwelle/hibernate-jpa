package org.eclipse.relations;

import org.eclipse.model.Address;
import org.eclipse.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.cfg.Configuration;

public class AppOneToMany {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration().configure();
				
		try(SessionFactory sessionFactory = configuration.buildSessionFactory()){
			
			try(Session session = sessionFactory.openSession()){
        	        		
	        	try{
	      
	        		User user = session.find(User.class, 1);
	        		
	        		Address address1 = new Address("Lyon", "13015", "Marseille");
	        		Address address2 = new Address("Plantes", "75014", "Paris");
	        		Address address3 = new Address("Billancourt", "92000", "Boulogne");
	        		
	        		user.addAddress(address1);
	        		user.addAddress(address2);
	        		user.addAddress(address3);
	        		
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