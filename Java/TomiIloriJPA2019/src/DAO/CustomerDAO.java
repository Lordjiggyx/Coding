package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Entites.Customer;
import Entites.Customer;
import Entites.Customer;
import Entites.Customer;

public class CustomerDAO {
	protected static EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("TPU"); 
	

	public CustomerDAO() {
		// TODO Auto-generated constructor stub
	}

	public void persistCustomer(Customer Customer) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(Customer);
		em.getTransaction().commit();
		em.close();
	}
	
	public void mergeCustomer(Customer Customer){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Customer updatedCustomer = em.merge(Customer);
		em.getTransaction().commit();
		em.close();
	}
	
	public void removeCustomer(Customer Customer){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(Customer));
		em.getTransaction().commit();
		em.close();
}
	
	public List<Customer> getAllCustomers(){
		EntityManager em = emf.createEntityManager();
		//calling the method nameQuery of what is in Subscriber class
		List<Customer> Customer = (List<Customer>)em.createNamedQuery("Customer.findAll").getResultList();
		em.close();
	
		return Customer;
	}
	
	public Customer UpdateCustomerUsername(int id , String NewName)
	{
		EntityManager em = emf.createEntityManager();
		List<Customer> Customers = (List<Customer>) em.createNamedQuery("Customer.findByid").setParameter("id", id).getResultList();
		
		
		Customer Customer = new Customer();
		for(Customer a: Customers){
			Customer = a;
		}		
		
		Customer.setUsername(NewName);
		
		em.getTransaction().begin();
		Customer updatedCustomer = em.merge(Customer);
		em.getTransaction().commit();
		em.close();
		return updatedCustomer;
	}
	
	public Customer UpdateCustomerEmail(int id , String NewEmail)
	{
		EntityManager em = emf.createEntityManager();
		List<Customer> Customers = (List<Customer>) em.createNamedQuery("Customer.findByid").setParameter("id", id).getResultList();
		
		
		Customer Customer = new Customer();
		for(Customer a: Customers){
			Customer = a;
		}		
		
		Customer.setEmail(NewEmail);
		
		em.getTransaction().begin();
		Customer updatedCustomer = em.merge(Customer);
		em.getTransaction().commit();
		em.close();
		return updatedCustomer;
	}
	
	public void  RemoveCustomerById(int id)
	{
		EntityManager em = emf.createEntityManager();
		List<Customer> Customers = (List<Customer>) em.createNamedQuery("Customer.findByid").setParameter("id", id).getResultList();
		
		Customer Customer = new Customer();
		for(Customer b: Customers){
			Customer = b;
		}		
		
		
		em.getTransaction().begin();
		em.remove(Customer);
		em.getTransaction().commit();
		em.close();

	}
}
