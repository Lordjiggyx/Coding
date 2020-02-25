
public class Member
{

	private String firstname;
	private String lastname;

		public Member(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}
		public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
		public Member() {
			// TODO Auto-generated constructor stub
		}

	}