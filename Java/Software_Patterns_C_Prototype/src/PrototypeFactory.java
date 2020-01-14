public class PrototypeFactory
{
    private static java.util.Map<String , PrototypeCapable> prototypes = new java.util.HashMap<String , PrototypeCapable>();
 
    static
    {
        prototypes.put(ModelType.MOVIE, new Movie());
        prototypes.put(ModelType.ALBUM, new Album());
        prototypes.put(ModelType.SHOW, new Show());
    }
 
    public static PrototypeCapable getInstance(final String s) throws CloneNotSupportedException {
        return ((PrototypeCapable) prototypes.get(s)).clone();
    }

    /* We define an additional method to allow a prototype to be created and passed new values */
    
    public static PrototypeCapable initialiseInstance(final String s, String name) throws CloneNotSupportedException {
        return ((PrototypeCapable) prototypes.get(s)).initialise(name);
    }

}