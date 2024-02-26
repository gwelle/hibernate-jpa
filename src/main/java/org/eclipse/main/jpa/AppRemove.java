package org.eclipse.main.jpa;

import org.eclipse.model.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class AppRemove {

	public static void main(String[] args) {
		
		try {
		
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-config");
			EntityManager em = emf.createEntityManager();
			
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			
			User user = em.getReference(User.class, 7);
			user.setEmail("fatima@creteil.fr");
			em.flush();
			transaction.commit();
			
			System.out.println(user);
			em.close();
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
		

}
