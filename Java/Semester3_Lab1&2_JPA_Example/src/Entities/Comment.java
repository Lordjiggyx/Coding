package Entities;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
@Entity

@NamedQueries({
	@NamedQuery(name = "Comment.findAll", query = "select o from Comment o"),
	@NamedQuery(name = "Comment.findByComments", query = "select o from Comment o where o.description=:description"),
	
})
public class Comment {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String description;
	

	public Comment() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Comment (String description) 
	{
		
		this.description = description;
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

	

}
