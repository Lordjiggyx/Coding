package Entities;
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

@NamedQueries ({                                                                                                                                            
	@NamedQuery(name = "Profile.findAll", query = "select o from Profile o"),                                                                         
	@NamedQuery (name = "Profile.findByDescription", query = "select o from Profile o where o.description=:description"), //:description, suits to wat u want back
})    

@Entity
public class Profile {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String description;
	
	@OneToMany(cascade=CascadeType.REMOVE , fetch = FetchType.EAGER)
	private List<Comment> comments = new ArrayList<Comment>();
	
	public Profile() {
		// TODO Auto-generated constructor stub
	}
	
	//use two constructors as comments are not needed at beginning of profile
	public Profile(String description) {
		super();
		this.description = description;
	}
	
	
	public Profile( String description , List<Comment> comments) {
		this.description = description;
		this.comments = comments;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	

	//Go to the list add comment to the list
	public void addComments(Comment comment){
		comments.add(comment);
	}
	
	public void removeComments(Comment comment){
		comments.remove(comment);
	}
	

	
	

}
