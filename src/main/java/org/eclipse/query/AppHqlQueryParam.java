package org.eclipse.query;

import org.eclipse.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class AppHqlQueryParam {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(User.class);
				
		try(SessionFactory sessionFactory = configuration.buildSessionFactory()){
			try(Session session = sessionFactory.openSession()){     		
	        	try{
	        		
	        		Query<User> query = session.createNamedQuery("usersByRole",User.class);
	        		//String query = "FROM User u WHERE u.role = :role";
	        		//Query<User> query = session.createQuery(query,User.class);
	        		query.setParameter("role", "USER");
	        		
	        		System.out.println(query.list());
	        	}
	        		
	        	catch (Exception e) {
	        		System.out.println(e.getCause());
	        	}
			}
		}
     
        catch(NoClassDefFoundError e) {
        	e.printStackTrace();	
        }
	}
}
