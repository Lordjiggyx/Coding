 package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Entites.Store;
import Entites.Store;
import Entites.Store;
import Entites.Store;

public class StoreDAO {

	protected static EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("TPU"); 
	public StoreDAO() {
		// TODO Auto-generated constructor stub
	}

	 
	
	public void persistStore(Store Store) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(Store);
		em.getTransaction().commit();
		em.close();
	}
	
	public void mergeStore(Store Store){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Store updatedStore = em.merge(Store);
		em.getTransaction().commit();
		em.close();
	}
	
	public void removeStore(Store Store){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(Store));
		em.getTransaction().commit();
		em.close();
}
	
	//Get All Stores
	public List<Store> getAllStores(){
		EntityManager em = emf.createEntityManager();
		//calling the method nameQuery of what is in Subscriber class
		List<Store> Stores = (List<Store>)em.createNamedQuery("Store.findAll").getResultList();
		em.close();
	
		return Stores;
	}
	
	//Update Store Name
	public Store UpdateStoreName(int id , String NewName)
	{
		EntityManager em = emf.createEntityManager();
		List<Store> Stores = (List<Store>) em.createNamedQuery("Store.findByid").setParameter("id", id).getResultList();
		
		
		Store Store = new Store();
		for(Store s: Stores){
			Store = s;
		}		
		
		Store.setName(NewName);
		
		em.getTransaction().begin();
		Store updatedStore = em.merge(Store);
		em.getTransaction().commit();
		em.close();
		return updatedStore;
	}
	
	public void  RemoveStoreById(int id)
	{
		EntityManager em = emf.createEntityManager();
		List<Store> Stores = (List<Store>) em.createNamedQuery("Store.findByid").setParameter("id", id).getResultList();
		
		Store Store = new Store();
		for(Store b: Stores){
			Store = b;
		}		
		
		
		em.getTransaction().begin();
		em.remove(Store);
		em.getTransaction().commit();
		em.close();

	}
}
