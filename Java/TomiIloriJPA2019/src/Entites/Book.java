package Entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


@NamedQueries
({
	@NamedQuery(name = "Book.findAll", query = "select b from Book b"),
	@NamedQuery (name = "Book.findByid", query = "select b from Book b where b.id=:id"),
	/*@NamedQuery (name = "Book.findByAuthor",query = 
				"select a from " 
						),*/
	
})

@Entity
public class Book {



	private String Title;
	private int year ;
	private int price;
	private String blurb;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToMany(mappedBy = "books")
	private List<Store> stores = new ArrayList<Store>();
	
	
	public Book() {
		// TODO Auto-generated constructor stub
		
	}
	
	public Book(String title, int year, int price, String blurb) {
		super();
		this.Title = title;
		this.year = year;
		this.price = price;
		this.blurb = blurb;
		
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getBlurb() {
		return blurb;
	}

	public void setBlurb(String blurb) {
		this.blurb = blurb;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Store> getStores() {
		return stores;
	}

	public void setStores(List<Store> stores) {
		this.stores = stores;
	}
	
	public void addstores(Store store){

			this.stores.add(store);
		
	}
	
	public void removestores(Store store){
		stores.remove(store);
	}

}
