package Entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@NamedQueries
({
	@NamedQuery(name = "Store.findAll", query = "select s from Store s"),
	@NamedQuery (name = "Store.findByid", query = "select s from Store s where s.id=:id"),
}
)

@Entity
public class Store {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String Name;
	

	@ManyToMany(cascade = CascadeType.REMOVE)
	private List<Book> books= new ArrayList<Book>();
	
	public Store()
	{
		 
	}

	
	public Store(String name ) {
		// TODO Auto-generated constructor stub
		super();
		this.Name = name;
	}

	public Store(String name, List<Book> books ) {
		super();
		this.Name = name;
		
		this.books = books;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public void addBooks(Book book){
	this.books.add(book);
	}
	
	public void removeBooks(Book book){
		books.remove(book);
	}


	public List<Book> getBooks() {
		return books;
	}


	public void setBooks(List<Book> books) {
		this.books = books;
	}


}
