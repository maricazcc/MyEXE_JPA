package it.maricazocco.myexe_jpa;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class MyEXE_JPA {
	
	private static EntityManagerFactory myEntityManagerFactory = Persistence.createEntityManagerFactory("MyEXE_JPA");
		
	public static void main(String[] args) {

		Cliente c = new Cliente("Aldo", "Baglio", "1234");
        insertCliente(c);

        /*c.setNome("Aldo");
        updateClienteById(c);

        getAllClienti();

        deleteClienteById(c);*/

        Prodotto p = new Prodotto("Computer", "Lenovo", 890.99);
        insertProdotto(p);
        
        /*p.setPrezzo(500.99);
        updateProdottoById(p);
        
        getAllProdotti();
        
        deleteProdottoById(p);
        
        MyEXE_JPQL myJPQL = new MyEXE_JPQL();
        
        
		myJPQL.updateClienteByCognome("Rosa", c);
		
		myJPQL.updateProdottoByMarca("Apple", p);
		
		myJPQL.namedQuery(399.99, 699.99);*/
        
        MyEXE_CRUD myexe_CRUD = new MyEXE_CRUD();
        Ordine ordine = new Ordine(c, p);
        
        myexe_CRUD.insertOrdine(ordine);
        
              
        /*Prodotto p2 = new Prodotto("Radio", "Sony", 99.99);
        insertProdotto(p2);
          
        myexe_CRUD.updateOrdine(ordine, p2);*/
        //deleteClienteById(c);
        //deleteProdottoById(p);
        //myexe_CRUD.deleteOrdine(ordine);
        
        myexe_CRUD.getAllOrdini();
	
      	
	}
		
	
		public static void insertCliente(Cliente cliente) {	
			 EntityManager myEntityManager  = myEntityManagerFactory.createEntityManager();
			 EntityTransaction myEntityTransaction = myEntityManager.getTransaction();
		try {
			System.out.println("\nInsert ");
			myEntityTransaction.begin();
			myEntityManager.persist(cliente);
			myEntityTransaction.commit();
		} catch(Exception e) {
			System.out.println("Errore: " + e);
		} finally {
			myEntityManager.close();
			}
		}
		
		public static void updateClienteById(Cliente cliente) {
			EntityManager myEntityManager  = myEntityManagerFactory.createEntityManager();
		    EntityTransaction myEntityTransaction = myEntityManager.getTransaction();
		try {
				System.out.println("\nUpdate");			
				myEntityTransaction.begin();
				Cliente c = myEntityManager.find(Cliente.class, cliente.getIdCliente());
				c.setNome(cliente.getNome());
				c.setCognome(cliente.getCognome());
				c.setCartaDiCredito(cliente.getCartaDiCredito());
				
				myEntityTransaction.commit();
			} catch(Exception e) {
				System.out.println("Errore: " + e);
			} finally {
				myEntityManager.close();
			}
		}
		
		public static void deleteClienteById(Cliente cliente) {
			  EntityManager myEntityManager  = myEntityManagerFactory.createEntityManager();
			  EntityTransaction myEntityTransaction = myEntityManager.getTransaction();
			try {
				System.out.println("\nDelete");
				myEntityTransaction.begin();
				Cliente c = myEntityManager.find(Cliente.class, cliente.getIdCliente());
				if (c != null) myEntityManager.remove(c);

				myEntityTransaction.commit();
			} catch(Exception e) {
				System.out.println("Errore: " + e);
			} finally {
				myEntityManager.close();
			}
			
		}
		
		public static void getAllClienti() {	
			  EntityManager myEntityManager  = myEntityManagerFactory.createEntityManager();
        try {
            List<Cliente> lista = myEntityManager.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();

            lista.forEach(c ->  System.out.println(c.toString()));
        } finally {
            myEntityManager.close();
        }
	}
		
		public static void insertProdotto(Prodotto prodotto) {	
			  EntityManager myEntityManager  = myEntityManagerFactory.createEntityManager();
			  EntityTransaction myEntityTransaction = myEntityManager.getTransaction();
		try {
			System.out.println("\nInsert ");
			myEntityTransaction.begin();
			myEntityManager.persist(prodotto);
			myEntityTransaction.commit();
		} catch(Exception e) {
			System.out.println("Errore: " + e);
		} finally {
			myEntityManager.close();
			}
		}
		
		public static void updateProdottoById(Prodotto prodotto) {
			  EntityManager myEntityManager  = myEntityManagerFactory.createEntityManager();
			  EntityTransaction myEntityTransaction = myEntityManager.getTransaction();
		try {
				System.out.println("\nUpdate");			
				myEntityTransaction.begin();
				Prodotto p = myEntityManager.find(Prodotto.class, prodotto.getIdProdotto());
				p.setNome(prodotto.getNome());
				p.setMarca(prodotto.getMarca());
				p.setPrezzo(prodotto.getPrezzo());
			
				myEntityTransaction.commit();
			} catch(Exception e) {
				System.out.println("Errore: " + e);
			} finally {
				myEntityManager.close();
			}
		}
		
		public static void deleteProdottoById(Prodotto prodotto) {
			  EntityManager myEntityManager  = myEntityManagerFactory.createEntityManager();
			  EntityTransaction myEntityTransaction = myEntityManager.getTransaction();
			try {
				System.out.println("\nDelete");	
				myEntityTransaction.begin();
				Prodotto p = myEntityManager.find(Prodotto.class, prodotto.getIdProdotto());
				if (p != null) myEntityManager.remove(p);

				myEntityTransaction.commit();
			} catch(Exception e) {
				System.out.println("Errore: " + e);
			} finally {
				myEntityManager.close();
			}
			
		}
		
		public static void getAllProdotti() {	
			  EntityManager myEntityManager  = myEntityManagerFactory.createEntityManager();

        try {
            List<Prodotto> lista = myEntityManager.createQuery("SELECT p FROM Prodotto p", Prodotto.class).getResultList();

            lista.forEach(p ->  System.out.println(p.toString()));
        } finally {
            myEntityManager.close();
        }
	}


}
