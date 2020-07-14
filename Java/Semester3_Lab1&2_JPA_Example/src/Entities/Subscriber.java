package Entities;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;



//this is class part of hiberinate - need to get jar files   
//select * from in DB
@NamedQueries ({
	@NamedQuery(name = "Subscriber.findAll", query = "select o from Subscriber o"),
	@NamedQuery (name = "Subscriber.findByUsername", query = "select o from Subscriber o where o.username=:username"),
	})
@Entity
public class Subscriber {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String username;
	private String password;
	
	@OneToOne(cascade=CascadeType.REMOVE)
	private Profile profile;
	
	public Subscriber() {
		
	}

	public Subscriber(String username, String password , Profile profile) {
		
		this.username = username;
		this.password = password;
		this.profile = profile;
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
	
	

}