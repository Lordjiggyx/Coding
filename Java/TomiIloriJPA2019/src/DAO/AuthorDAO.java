package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Entites.Author;
import Entites.Author;
import Entites.Author;
import Entites.Author;

public class AuthorDAO {
	protected static EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("TPU"); 
	public AuthorDAO() {
		// TODO Auto-generated constructor stub
	}

	public void persistAuthor(Author auth) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(auth);
		em.getTransaction().commit();
		em.close();
	}
	
	public void mergeAuthor(Author auth){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Author updatedauth = em.merge(auth);
		em.getTransaction().commit();
		em.close();
	}
	
	public void removeAuthor(Author auth){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(auth));
		em.getTransaction().commit();
		em.close();
}
	
	//Get All Authors
	public List<Author> getAllAuthors(){
		EntityManager em = emf.createEntityManager();
		//calling the method nameQuery of what is in Subscriber class
		List<Author> Authors = (List<Author>)em.createNamedQuery("Author.findAll").getResultList();
		em.close();
	
		return Authors;
	}
	
	//Update Author Name
	public Author UpdateName(int id , String NewName)
	{
		EntityManager em = emf.createEntityManager();
		List<Author> Authors = (List<Author>) em.createNamedQuery("Author.findByid").setParameter("id", id).getResultList();
		
		
		Author Author = new Author();
		for(Author a: Authors){
			Author = a;
		}		
		
		Author.setName(NewName);
		
		em.getTransaction().begin();
		Author updatedAuthor = em.merge(Author);
		em.getTransaction().commit();
		em.close();
		return updatedAuthor;
	}
	//Update Author Age
	public Author UpdateAuthorAge(int id , int newAge)
	{
		EntityManager em = emf.createEntityManager();
		List<Author> Authors = (List<Author>) em.createNamedQuery("Author.findByid").setParameter("id", id).getResultList();
		
		
		Author Author = new Author();
		for(Author a: Authors){
			Author = a;
		}		
		
		Author.setAge(newAge);
		
		em.getTransaction().begin();
		Author updatedAuthor = em.merge(Author);
		em.getTransaction().commit();
		em.close();
		return updatedAuthor;
	}
	
	public void  RemoveAuthorById(int id)
	{
		EntityManager em = emf.createEntityManager();
		List<Author> Authors = (List<Author>) em.createNamedQuery("Author.findByid").setParameter("id", id).getResultList();
		
		Author Author = new Author();
		for(Author b: Authors){
			Author = b;
		}		
		
		
		em.getTransaction().begin();
		em.remove(Author);
		em.getTransaction().commit();
		em.close();

	}
}
