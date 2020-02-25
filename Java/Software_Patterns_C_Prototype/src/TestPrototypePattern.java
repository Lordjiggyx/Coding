public class TestPrototypePattern
{
    public static void main(String[] args)
    {
        try
        {

        	/* Using clone() and initialise() to create two instances of the same type and then checking their
        	 * hash codes */
        	
        	PrototypeCapable moviePrototype1  = PrototypeFactory.getInstance(ModelType.MOVIE);
            System.out.println(moviePrototype1.toString() + " Hash code " + moviePrototype1.hashCode());
 
            PrototypeCapable moviePrototype2  = PrototypeFactory.initialiseInstance(ModelType.MOVIE, "Blazing Saddles");
            System.out.println(moviePrototype2.toString() + " Hash code " + moviePrototype2.hashCode());
 
            PrototypeCapable albumPrototype1  = PrototypeFactory.getInstance(ModelType.ALBUM);
            System.out.println(albumPrototype1.toString() + " Hash code " + albumPrototype1.hashCode());
 
            PrototypeCapable albumPrototype2  = PrototypeFactory.initialiseInstance(ModelType.ALBUM, "Astral Weeks");
            System.out.println(albumPrototype2.toString() + " Hash code " + albumPrototype2.hashCode());
 
            PrototypeCapable showPrototype1  = PrototypeFactory.getInstance(ModelType.SHOW);
            System.out.println(showPrototype1.toString() + " Hash code " + showPrototype1.hashCode());
 
            PrototypeCapable showPrototype2  = PrototypeFactory.initialiseInstance(ModelType.SHOW, "Miss Saigon");
            System.out.println(showPrototype2.toString() + " Hash code " + showPrototype2.hashCode());
 
        }
        catch (CloneNotSupportedException e)
        {
            e.printStackTrace();
        }
    }
}