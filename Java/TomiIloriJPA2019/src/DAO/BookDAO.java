package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Entites.Book;



public class BookDAO {

	public BookDAO() {
		// TODO Auto-generated constructor stub
	}
	
	protected static EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("TPU"); 
	
	
	public void persistBook(Book book) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(book);
		em.getTransaction().commit();
		em.close();
	}
	
	public void mergeBook(Book book){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Book updatedbook = em.merge(book);
		em.getTransaction().commit();
		em.close();
	}
	
	public void removeBook(Book book){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(book));
		em.getTransaction().commit();
		em.close();
		
		}
	
	//Get All Books
		public List<Book> getAllBooks(){
			EntityManager em = emf.createEntityManager();
			//calling the method nameQuery of what is in Subscriber class
			List<Book> Books = (List<Book>)em.createNamedQuery("Book.findAll").getResultList();
			em.close();
		
			return Books;
		}
		
		//Get All Books
				public List<Book> getBookByAuthor(int id){
					EntityManager em = emf.createEntityManager();
					
					List<Book> Books = (List<Book>)em.createNamedQuery("Book.findByAuthor").setParameter("id", id).getResultList();
					if(Books.isEmpty())
					{
						System.out.println("Author not found");
					}
					em.close();
				
					return Books;
				}

		//Update Book Title
				public Book UpdateBookTitle(int id , String NewTitle)
				{
					EntityManager em = emf.createEntityManager();
					List<Book> books = (List<Book>) em.createNamedQuery("Book.findByid").setParameter("id", id).getResultList();
					
					
					Book book = new Book();
					for(Book b: books){
						book = b;
					}		
					
					book.setTitle(NewTitle);
					
					em.getTransaction().begin();
					Book updatedBook = em.merge(book);
					em.getTransaction().commit();
					em.close();
					return updatedBook;
				}
				//Update Book Price
				public Book UpdateBookPrice(int id , int newPrice)
				{
					EntityManager em = emf.createEntityManager();
					List<Book> books = (List<Book>) em.createNamedQuery("Book.findByid").setParameter("id", id).getResultList();
					
					
					Book book = new Book();
					for(Book b: books){
						book = b;
					}		
					
					book.setPrice(newPrice);
					
					em.getTransaction().begin();
					Book updatedBook = em.merge(book);
					em.getTransaction().commit();
					em.close();
					return updatedBook;
				}
				
				public void  RemoveBookById(int id)
				{
					EntityManager em = emf.createEntityManager();
					List<Book> books = (List<Book>) em.createNamedQuery("Book.findByid").setParameter("id", id).getResultList();
					
					Book book = new Book();
					for(Book b: books){
						book = b;
					}		
					
					
					em.getTransaction().begin();
					em.remove(book);
					em.getTransaction().commit();
					em.close();

				}
}
