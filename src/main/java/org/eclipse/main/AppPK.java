package org.eclipse.main;

import org.eclipse.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AppPK {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration().configure();
		
		configuration.addAnnotatedClass(User.class);
				
		try(SessionFactory sessionFactory = configuration.buildSessionFactory()){
			
			try(Session session = sessionFactory.openSession()){
        	
        	Transaction transaction = null;
        		
        	try{
        		
        		User user = new User("jesus.christl@gmail.com","christ","USER");
        		transaction = session.beginTransaction();
        		session.persist(user);
        		session.flush();
        		Integer key = (Integer) session.save(user);
        		transaction.commit();
        		System.out.println("Success");
        		System.out.println(key);
        	}
        		
        		catch (Exception e) {
        			e.printStackTrace();
        			if(transaction != null) transaction.rollback();
				}
        	}
			
		}
        
        catch(NoClassDefFoundError e) {
        	e.printStackTrace();
        }

	}

}
