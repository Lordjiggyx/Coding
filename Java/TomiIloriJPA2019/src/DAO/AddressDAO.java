package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Entites.Address;
import Entites.Address;
import Entites.Address;
import Entites.Address;



public class AddressDAO {

	protected static EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("TPU"); 	
	
	
	public AddressDAO() {
		// TODO Auto-generated constructor stub
	}

	public void persistAddress(Address add) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(add);
		em.getTransaction().commit();
		em.close();
	}
	
	public void mergeAddress(Address add){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Address updatedAdd = em.merge(add);
		em.getTransaction().commit();
		em.close();
	}
	
	public void removeAddress(Address add){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(add));
		em.getTransaction().commit();
		em.close();
}
	//Get All Addresss
	public List<Address> getAllAddresses(){
		EntityManager em = emf.createEntityManager();
		//calling the method nameQuery of what is in Subscriber class
		List<Address> Addresses = (List<Address>)em.createNamedQuery("Address.findAll").getResultList();
		em.close();
	
		return Addresses;
	}
	
	public Address UpdateAddressCity(int id , String NewCity)
	{
		EntityManager em = emf.createEntityManager();
		List<Address> Addresss = (List<Address>) em.createNamedQuery("Address.findByid").setParameter("id", id).getResultList();
		
		
		Address Address = new Address();
		for(Address a: Addresss){
			Address = a;
		}		
		
		Address.setCity(NewCity);
		
		em.getTransaction().begin();
		Address updatedAdress = em.merge(Address);
		em.getTransaction().commit();
		em.close();
		return updatedAdress;
	}
	
	public Address UpdateAddressPostcode(int id , String NewPostCode)
	{
		EntityManager em = emf.createEntityManager();
		List<Address> Addresss = (List<Address>) em.createNamedQuery("Address.findByid").setParameter("id", id).getResultList();
		
		
		Address Address = new Address();
		for(Address a: Addresss){
			Address = a;
		}		
		
		Address.setPostcode(NewPostCode);
		
		em.getTransaction().begin();
		Address updatedAdress = em.merge(Address);
		em.getTransaction().commit();
		em.close();
		return updatedAdress;
	}
	
	public void  RemoveAddressById(int id)
	{
		EntityManager em = emf.createEntityManager();
		List<Address> Addresss = (List<Address>) em.createNamedQuery("Address.findByid").setParameter("id", id).getResultList();
		
		Address Address = new Address();
		for(Address b: Addresss){
			Address = b;
		}		
		
		
		em.getTransaction().begin();
		em.remove(Address);
		em.getTransaction().commit();
		em.close();
	}
	
}
