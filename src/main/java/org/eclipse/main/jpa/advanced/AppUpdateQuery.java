package org.eclipse.main.jpa.advanced;

import org.eclipse.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Root;

public class AppUpdateQuery {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(User.class);
				
		try(SessionFactory sessionFactory = configuration.buildSessionFactory()){
			try(Session session = sessionFactory.openSession()){     		
	        	try{
	        		
	        		CriteriaBuilder cb = session.getCriteriaBuilder();
	        		
	        		//Requête de type UPDATE
	        		CriteriaDelete<User> cd = cb.createCriteriaDelete(User.class);
	        		
	        		//Specifier l’élement de la clause from d’une requête SQL
	        		Root<User> root = cd.from(User.class);
	        		
	        		//Préciser l'id qu'il faut supprimer le role de l'user victorien
	        		cd.where(cb.between(root.get("id"), 5,6));
	        		
	        		Transaction tr = session.beginTransaction();
	        		
	        		MutationQuery query = session.createMutationQuery(cd);
	        		int nombre = query.executeUpdate();
	        		System.out.println(nombre);
	        		
	        		tr.commit();
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