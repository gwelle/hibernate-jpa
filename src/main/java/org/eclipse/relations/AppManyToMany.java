package org.eclipse.relations;

import org.eclipse.model.Address;
import org.eclipse.model.Sport;
import org.eclipse.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.cfg.Configuration;

public class AppManyToMany {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration().configure();
				
		try(SessionFactory sessionFactory = configuration.buildSessionFactory()){
			
			try(Session session = sessionFactory.openSession()){
        	        		
	        	try{
	      
	        		User user1 = session.find(User.class, 1);
	        		User user2 = session.find(User.class, 2);
	        		User user4 = session.find(User.class, 4);
	        		User user7 = session.find(User.class, 7);
	        		
	        		Sport s1 = new Sport("football", "collectif");
	        		Sport s2 = new Sport("tennis", "individuel");
	        		Sport s3 = new Sport("boxing", "collectif ou individuel");
	        		
	        		user1.addSport(s1);
	        		
	        		user2.addSport(s1);
	        		user2.addSport(s3);
	        		
	        		user4.addSport(s2);
	        		user4.addSport(s3);
	        		
	        		user7.addSport(s1);
	        		user7.addSport(s2);
	        		user7.addSport(s3);
	        		
	        		session.persist(user1);
	        		session.persist(user2);
	        		session.persist(user4);
	        		session.persist(user7);
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