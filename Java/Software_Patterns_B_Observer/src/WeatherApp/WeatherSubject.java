package WeatherApp;

//This is the Subject interface 
public interface WeatherSubject {

	//This will be used to register an observer to the subject's list of observers
	public void addOb(WeatherObserver o);
	//This will be used to unregister an observer to the subject's list of observers
	public void removeOb(WeatherObserver o);
	//This will be used to peform the update method in each observer class
	public void doNotify();
}
