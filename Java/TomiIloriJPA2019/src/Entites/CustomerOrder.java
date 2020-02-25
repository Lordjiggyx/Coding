 package Entites;

import java.util.ArrayList;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


@NamedQueries
({
	@NamedQuery(name = "CustomerOrder.findAll", query = "select c from CustomerOrder c"),
	//@NamedQuery (name = "Subscriber.findByUsername", query = "select o from Subscriber o where o.username=:username"),
})


@Entity
public class CustomerOrder {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	
	
	@OneToMany(orphanRemoval = true)
	private List<Book> books = new ArrayList<Book>();
	
	@ManyToOne
	private Customer customer;
	
	
	public CustomerOrder() {
		// TODO Auto-generated constructor stub
	}
	
	public Customer getCustomer()
	{
		return customer;
	}
	
	public void  SetCustomer(Customer customer)
	{
	 this.customer = customer;
	}
	
	
	public CustomerOrder(List<Book> books) {
		
		this.books = books;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	public void addBooks(Book book){
		books.add(book);
	}
	
	public void removeBooks(Book book){
		books.remove(book);
	}
	
}
