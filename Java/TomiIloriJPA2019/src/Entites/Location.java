package Entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@NamedQueries
({
	@NamedQuery(name = "Location.findAll", query = "select l from Location l"),
	@NamedQuery (name = "Location.findByid", query = "select l from Location l where l.id=:id"),
})

@Entity
public class Location {




	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@OneToMany
	private List<Store> stores = new ArrayList<Store>();
	
	@OneToOne(cascade = CascadeType.REMOVE ,orphanRemoval = true)
	private Address add;
	
	public Location()
	{
		
	}
	public Location(Address add ) {
		// TODO Auto-generated constructor stub
		super();
		this.add = add;
	}
	

	public Location(Address add, List<Store> stores) {
		super();
		this.add = add;
		this.stores = stores;
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
		stores.add(store);
	}
	
	public void removestores(Store store){
		stores.remove(store);
	}
}
