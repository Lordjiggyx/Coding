 package Entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries
({
	@NamedQuery(name = "Address.findAll", query = "select a from Address a"),
	@NamedQuery (name = "Address.findByid", query = "select a from Address a where a.id=:id"),
})

@Entity
public class Address {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String street;
	private String city;
	private String county;
	private String postcode;
	private String Country;

	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(String street, String city, String county, String postcode, String country) {
		super();
		this.street = street;
		this.city = city;
		this.county = county;
		this.postcode = postcode;
		this.Country = country;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

}
