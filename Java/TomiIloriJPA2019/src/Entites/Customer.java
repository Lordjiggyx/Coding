package Entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@NamedQueries
({
	@NamedQuery(name = "Customer.findAll", query = "select c from Customer c"),
	@NamedQuery (name = "Customer.findByid", query = "select c from Customer c where c.id=:id"),
})


@Entity
public class Customer {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String username;
	private String password;
	private String email;
	
	@OneToMany(mappedBy = "customer" , cascade = CascadeType.REMOVE ,  fetch = FetchType.EAGER)
	private List<CustomerOrder> orders = new ArrayList<CustomerOrder>();
	
	public Customer()
	{
		
	}
	
	public Customer(String username, String password, String email) {
		// TODO Auto-generated constructor stub
		super();
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	public Customer(String username, String password, String email , List<CustomerOrder> orders) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.orders = orders;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<CustomerOrder> getOrders() {
		return orders;
	}

	public void setOrders(List<CustomerOrder> orders) {
		this.orders = orders;
	}
	
	public void addOrders(CustomerOrder ord){
		orders.add(ord);
		
	}
	
	public void removeOrders(CustomerOrder ord){
		orders.remove(ord);
		ord.SetCustomer(null);
	}

}
