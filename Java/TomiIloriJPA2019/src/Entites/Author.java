package Entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@NamedQueries
({
	@NamedQuery(name = "Author.findAll", query = "select a from Author a"),
	@NamedQuery (name = "Author.findByid", query = "select a from Author a where a.id=:id"),
})




@Entity
public class Author {



	private String Name;
	private int age ;
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.REMOVE)
	private List<Book> books = new ArrayList<Book>();
	
	public Author()
	{
		
	}

	public Author(String name, int age)
	{
		super();
		this.Name = name;
		this.age = age;
	}
	
	public Author(String name, int age,  List<Book> books) {
		super();
		this.Name = name;
		this.age = age;
		
		this.books = books;
	}
	
	
	

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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
