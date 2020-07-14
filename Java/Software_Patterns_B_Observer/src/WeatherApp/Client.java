package WeatherApp;

public class Client {
	public static void main(String[] args) {
		
	//Create subject object
	WeatherData wd = new WeatherData();
	
	//Create Concrete observer objects passing in the subject
	CurrentConditionsDisplay ccd = new CurrentConditionsDisplay(wd);
	ForecastDisplay fd = new ForecastDisplay(wd);
	HeatIndexDisplay hid = new HeatIndexDisplay(wd);
	StatisticsDisplay sd = new StatisticsDisplay(wd);
	
	//Call the set method for the subject which in turn will call each Concrete observers display method
	System.out.println("First Change of 1");
	wd.setMeasurements(1, 1, 1);
	
	System.out.println("Second Change of 2");
	wd.setMeasurements(2, 2, 2);
	
	System.out.println("Third Change of 3");
	wd.setMeasurements(3, 3, 3);
	
}
}
