package Applications;

public class Book 
{
	private String title;
	private String author;
	private String Yop;
	
	public Book()
	{
		this.title = " ";
		this.author = " ";
		this.Yop = " ";
	}
	
	public Book(String a, String b, String c)
	{
		this.title = a;
		this.author = b;
		this.Yop = c;
	}

	public String getTitle() 
	{
		return title;
	}

	public void setTitle(String title) 
	{
		this.title = title;
	}

	public String getAuthor()
	{
		return author;
	}

	public void setAuthor(String author)
	{
		this.author = author;
	}

	public String getYop()
	{
		return Yop;
	}

	public void setYop(String yop) 
	{
		Yop = yop;
	}

	@Override
	public String toString() {
		return "The Book:" + this.title  + " " + "was written by " + this.author + " " + "in" + " " + this.Yop;
	}
	
	public boolean equals(Object otherObject)
	{
		Book otherbook = (Book) otherObject;
		if (this.getTitle() == otherbook.getTitle() && this.getAuthor() == otherbook.getTitle() && this.getYop()== otherbook.getYop())
			return true;
		else 
			return false;
 	}
	
}
