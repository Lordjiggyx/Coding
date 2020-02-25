public interface PrototypeCapable extends Cloneable
{
    public PrototypeCapable clone() throws CloneNotSupportedException;
    
    /* We add an initialise method to our interface */
    
    public PrototypeCapable initialise(String s) throws CloneNotSupportedException;
    
}