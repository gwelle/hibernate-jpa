package org.eclipse.main.jpa.advanced;

import java.util.List;

import org.eclipse.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class AppSelectQuery {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(User.class);
				
		try(SessionFactory sessionFactory = configuration.buildSessionFactory()){
			try(Session session = sessionFactory.openSession()){     		
	        	try{
	        		
	        		CriteriaBuilder cb = session.getCriteriaBuilder();
	        		
	        		//Requête de type SELECT
	        		CriteriaQuery<User> cr = cb.createQuery(User.class);
	        		
	        		//Specifier l’élement de la clause from d’une requête SQL
	        		Root<User> root = cr.from(User.class);
	        		
	        		//Specifions ce qu’il faut selectionner et retourner par la requête ˆ
	        		cr.select(root);
	        		
	        		//Exécution de la requete SQL par la Session
	        		Query query = session.createQuery(cr);
	        		
	        		//Récupération du résultat sous forme de liste
	        		@SuppressWarnings("unchecked")
					List<User> results = query.getResultList();
	        		
	        		results.forEach(System.out::println);
	        		
	        		
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