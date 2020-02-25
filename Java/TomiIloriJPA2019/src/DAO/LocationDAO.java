package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Entites.Location;
import Entites.Location;
import Entites.Location;

public class LocationDAO {

	protected static EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("TPU"); 
	public LocationDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public void persistLocation(Location Location) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(Location);
		em.getTransaction().commit();
		em.close();
	}
	
	public void mergeLocation(Location Location){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Location updatedLocation = em.merge(Location);
		em.getTransaction().commit();
		em.close();
	}
	
	public void removeLocation(Location Location){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(Location));
		em.getTransaction().commit();
		em.close();
}
	
	public List<Location> getAllLocations(){
		EntityManager em = emf.createEntityManager();
		//calling the method nameQuery of what is in Subscriber class
		List<Location> Locations = (List<Location>)em.createNamedQuery("Location.findAll").getResultList();
		em.close();
	
		return Locations;
	}

	public void  RemoveLocationById(int id)
	{
		EntityManager em = emf.createEntityManager();
		List<Location> Locations = (List<Location>) em.createNamedQuery("Location.findByid").setParameter("id", id).getResultList();
		
		Location Location = new Location();
		for(Location b: Locations){
			Location = b;
		}		
		
		
		em.getTransaction().begin();
		em.remove(Location);
		em.getTransaction().commit();
		em.close();

	}
}
