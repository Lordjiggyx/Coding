package WeatherApp;

//This is the Observer Interface
public interface WeatherObserver {
	//Method that updates values in each concrete observer
	public void update(float t , float h , float ap);

}
