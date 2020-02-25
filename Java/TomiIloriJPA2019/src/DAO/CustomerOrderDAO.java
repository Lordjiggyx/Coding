package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Entites.CustomerOrder;
import Entites.CustomerOrder;
import Entites.CustomerOrder;

public class CustomerOrderDAO {

	protected static EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("TPU"); 
	public CustomerOrderDAO() {
		// TODO Auto-generated constructor stub
	}

	 
	
	public void persistOrder(CustomerOrder Order) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(Order);
		em.getTransaction().commit();
		em.close();
	}
	
	public void mergeOrder(CustomerOrder Order){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		CustomerOrder updatedOrder = em.merge(Order);
		em.getTransaction().commit();
		em.close();
	}
	
	public void removeOrder(CustomerOrder Order){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(Order));
		em.getTransaction().commit();
		em.close();
}
	
	public List<CustomerOrder> getAllCustomerOrders(){
		EntityManager em = emf.createEntityManager();
		//calling the method nameQuery of what is in Subscriber class
		List<CustomerOrder> CustomerOrders = (List<CustomerOrder>)em.createNamedQuery("CustomerOrder.findAll").getResultList();
		em.close();
	
		return CustomerOrders;
	}
	
	public void  RemoveCustomerOrderById(int id)
	{
		EntityManager em = emf.createEntityManager();
		List<CustomerOrder> CustomerOrders = (List<CustomerOrder>) em.createNamedQuery("CustomerOrder.findByid").setParameter("id", id).getResultList();
		
		CustomerOrder CustomerOrder = new CustomerOrder();
		for(CustomerOrder b: CustomerOrders){
			CustomerOrder = b;
		}		
		
		
		em.getTransaction().begin();
		em.remove(CustomerOrder);
		em.getTransaction().commit();
		em.close();

	}

}
