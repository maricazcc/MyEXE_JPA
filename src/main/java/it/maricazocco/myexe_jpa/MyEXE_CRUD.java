package it.maricazocco.myexe_jpa;


import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;



public class MyEXE_CRUD {
	
	static EntityManagerFactory myEntityManagerFactory = Persistence.createEntityManagerFactory("MyEXE_JPA");

	
	// Creazione
	public static void insertOrdine(Ordine o) {	
		 EntityManager myEntityManager  = myEntityManagerFactory.createEntityManager();
		 EntityTransaction myEntityTransaction = myEntityManager.getTransaction();
	try {
		System.out.println("\nInsert ");
		
		myEntityTransaction.begin();
		myEntityManager.persist(o);
		myEntityTransaction.commit();
	} catch(Exception e) {
		System.out.println("Errore: " + e);
	} finally {
		myEntityManager.close();
		}
	}

	public static void updateOrdine(Ordine o, Prodotto p) {
		EntityManager myEntityManager  = myEntityManagerFactory.createEntityManager();
	    EntityTransaction myEntityTransaction = myEntityManager.getTransaction();
	try {
			System.out.println("\nUpdate");			
			myEntityTransaction.begin();
			Ordine ordine = myEntityManager.find(Ordine.class, o.getIdOrdine());
			Prodotto prodotto = myEntityManager.find(Prodotto.class, p.getIdProdotto());
			ordine.setProdotto(prodotto);
			
			myEntityTransaction.commit();
		} catch(Exception e) {
			System.out.println("Errore: " + e);
		} finally {
			myEntityManager.close();
		}
	}
	
	public static void deleteOrdine(Ordine o) {
		  EntityManager myEntityManager  = myEntityManagerFactory.createEntityManager();
		  EntityTransaction myEntityTransaction = myEntityManager.getTransaction();
		try {
			System.out.println("\nDelete");
			myEntityTransaction.begin();
			Ordine ordine = myEntityManager.find(Ordine.class, o.getIdOrdine());
			if (o != null) myEntityManager.remove(ordine);

			myEntityTransaction.commit();
		} catch(Exception e) {
			System.out.println("Errore: " + e);
		} finally {
			myEntityManager.close();
		}
		
	}
	
	public static void getAllOrdini() {	
		  EntityManager myEntityManager  = myEntityManagerFactory.createEntityManager();
		  try {
			  List<Ordine> lista = myEntityManager.createQuery("SELECT o FROM Ordine o", Ordine.class).getResultList();

			  lista.forEach(o ->  System.out.println(o.toString()));
		  } finally {
			  myEntityManager.close();
		  }
	}
	

}
