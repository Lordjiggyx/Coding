
//Here is our TARGET interface for the adapter here we define methods for getting and setting the temperature in both celcius and fahrenheit
public interface TemperatureInfo {
	public double getTemperatureInF();

	public void setTemperatureInF(double temperatureInF);

	public double getTemperatureInC();

	public void setTemperatureInC(double temperatureInC);
}
