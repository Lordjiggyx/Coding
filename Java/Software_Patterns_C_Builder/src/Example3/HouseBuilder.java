package Example3;

//set steps for building a house
abstract class HouseBuilder {
    protected House house = new House();
    
    protected String showProgress() {
        return house.toString();
    }

    abstract public void buildFoundation();
    abstract public void buildFrame();
    abstract public void buildExterior();
    abstract public void buildInterior();
}