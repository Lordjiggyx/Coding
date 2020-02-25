public class Album implements PrototypeCapable
{
    private String name = null;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
 
    public Album clone() throws CloneNotSupportedException {
        System.out.println("Cloning Album object..");
        return (Album) super.clone();
    }
    
    public Album initialise(String name) throws CloneNotSupportedException {
    	Album myClone = (Album)clone();
    	myClone.setName(name);
    	return myClone;
    }
 
    public String toString() {
    	if (name != null)
    		return "Album: " + name;
    	else
    		return "Album";
    }
}
 
