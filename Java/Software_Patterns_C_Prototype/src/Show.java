public class Show implements PrototypeCapable
{
    private String name = null;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Show clone() throws CloneNotSupportedException {
        System.out.println("Cloning Show object..");
        return (Show) super.clone();
    }

    public Show initialise(String name) throws CloneNotSupportedException {
    	Show myClone = (Show)clone();
    	myClone.setName(name);
    	return myClone;
    }
 
    public String toString() {
    	if (name != null)
    		return "Show: " + name;
    	else
    		return "Show";
    }

}