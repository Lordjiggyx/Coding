public class Movie implements PrototypeCapable
{
    private String name = null;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
 
	public Movie clone() throws CloneNotSupportedException {
        System.out.println("Cloning Movie object..");
        return (Movie) super.clone();
    }
 
    public Movie initialise(String name) throws CloneNotSupportedException {
    	Movie myClone = (Movie)clone();
    	myClone.setName(name);
    	return myClone;
    }
 
	public String toString() {
    	if (name != null)
    		return "Movie: " + name;
    	else
    		return "Movie";
    }
	
}
