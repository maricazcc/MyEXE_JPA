package it.maricazocco.myexe_jpa;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class MyEXE_JPQL {
	
	private static EntityManagerFactory myEntityManagerFactory = Persistence.createEntityManagerFactory("MyEXE_JPA");
	
	
	public void updateClienteByCognome(String cognome, Cliente cliente) {
		EntityManager myEntityManager  = myEntityManagerFactory.createEntityManager();
		EntityTransaction myEntityTransaction = myEntityManager.getTransaction();
		try {
			System.out.println("\nUpdate");			
			String myUpdate = "UPDATE Cliente c SET c.cognome = :newCognome WHERE c.cognome = :oldCognome";
			Query myQuery = myEntityManager.createQuery(myUpdate);
			myEntityTransaction.begin();
			
			myQuery.setParameter("newCognome", cognome);
			myQuery.setParameter("oldCognome", cliente.getCognome());
			int myUpdatedEntities = myQuery.executeUpdate();
			myEntityTransaction.commit();
			System.out.println("Entità aggiornate: " + myUpdatedEntities);
		} catch(Exception e) {
			System.out.println("Errore: " + e);
		} finally {
			myEntityManager.close();
		}
	}
	
	public void updateProdottoByMarca(String marca, Prodotto prodotto) {
		EntityManager myEntityManager  = myEntityManagerFactory.createEntityManager();
		EntityTransaction myEntityTransaction = myEntityManager.getTransaction();
		try {
			System.out.println("\nUpdate");			
			String myUpdate = "UPDATE Prodotto p SET p.marca = :newMarca WHERE p.marca = :oldMarca";
			Query myQuery = myEntityManager.createQuery(myUpdate);
			myEntityTransaction.begin();
			
			myQuery.setParameter("newMarca", marca);
			myQuery.setParameter("oldMarca", prodotto.getMarca());
			int myUpdatedEntities = myQuery.executeUpdate();
			myEntityTransaction.commit();
			System.out.println("Entità aggiornate: " + myUpdatedEntities);
		} catch(Exception e) {
			System.out.println("Errore: " + e);
		} finally {
			myEntityManager.close();
		}
	}
	
	public void namedQuery(double min, double max) {
		EntityManager myEntityManager  = myEntityManagerFactory.createEntityManager();
		try {
			System.out.println("\nNamedQuery");
			Query myNamedQuery = myEntityManager.createNamedQuery("ProdottiByPrezzo", Prodotto.class)
			.setParameter("myMin", min)
			.setParameter("myMax", max);		
			@SuppressWarnings("unchecked")
			List<Prodotto> prodotti = myNamedQuery.getResultList();			
			prodotti.forEach(prodotto -> System.out.println(prodotto));
		} catch(Exception e) {
			System.out.println("Errore: " + e);
		} finally {
			myEntityManager.close();
		}
	}
	
}
