package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Entities.Subscriber;

public class SubscriberDAO {
	
	protected static EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("TPU"); 	
	
	public SubscriberDAO() {
		
	}
	
	public void persistSubscriber(Subscriber subscriber) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(subscriber);
		em.getTransaction().commit();
		em.close();
	}
	
	//calling Subscriber namedQuery request 
	public List<Subscriber> getAllSubscribers(){
		EntityManager em = emf.createEntityManager();
		//calling the method nameQuery of what is in Subscriber class
		List<Subscriber> subscribers = (List<Subscriber>)em.createNamedQuery("Subscriber.findAll").getResultList();
		em.close();
	
		return subscribers;
	}
	
	//calling Subscriber namedQuery request and getting the first Username with that name
	public Subscriber getSubscriberByUsername(String username){
	EntityManager em = emf.createEntityManager();
		//setParameter("username") this is whatever variable (String username) the parm)also is called in the Subscriber NamedQuery
		List<Subscriber> subscribers = (List<Subscriber>)em.createNamedQuery("Subscriber.findByUsername").setParameter("username", username ).getResultList();
		em.close();
		
		//Get the first subscriber with that user name
		Subscriber sub = new Subscriber();
		for(Subscriber s: subscribers){
			sub = s;
		}		
		return sub;	
	}
	
	public Subscriber UpdateByUsername(String Changedname , String username)
	{
		EntityManager em = emf.createEntityManager();
		//setParameter("username") this is whatever variable (String username) the parm)also is called in the Subscriber NamedQuery
		List<Subscriber> subscribers = (List<Subscriber>) em.createNamedQuery("Subscriber.findByUsername").setParameter("username", username).getResultList();
		
		
		Subscriber sub = new Subscriber();
		for(Subscriber s: subscribers){
			sub = s;
		}		
		
		sub.setUsername(Changedname);
		
		em.getTransaction().begin();
		Subscriber updatedSubscriber = em.merge(sub);
		em.getTransaction().commit();
		em.close();
		return updatedSubscriber;
	}
	
	//Us the same chnagedname and username 
	//then get the user name like above
	//then call setter method on subscriber 
	//then merge 
	
	public Subscriber updateSubscriberName(Subscriber subscriber) {
	    EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Subscriber updatedSubscriber = em.merge(subscriber);
		em.getTransaction().commit();
		em.close();
		return updatedSubscriber;
		
	}
	
	public void mergeSubscriber(Subscriber subscriber){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Subscriber updatedSubscribers = em.merge(subscriber);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public void removeSubscriber(Subscriber subscriber){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(subscriber));
		em.getTransaction().commit();
		em.close();
		
	}
}
	