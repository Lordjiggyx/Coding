
//This is an example of a class adapater as you can fucking see
//IT EXTENDS THE ADAPTEE CLASS!!!!!
//AND IMPLEMENTS THE TARGET INTERFACE 
public class TemperatureClassReporter extends CelciusReporter implements TemperatureInfo {

	@Override
	//Uses the method from the adaptee class
	public double getTemperatureInC() {
		return temperatureInC;
	}

	@Override
	//This method is taken from the interface and it returns the value of temperature in fahrenheit as it is converted from C to F
	public double getTemperatureInF() {
		return cToF(temperatureInC);
	}

	@Override
	//Uses the method from the adaptee class
	public void setTemperatureInC(double temperatureInC) {
		this.temperatureInC = temperatureInC;
	}

	@Override
	//This method is taken from the interface and it Sets the value of temperature takeing in a Fahrenheit value and coverting it to celcius
	public void setTemperatureInF(double temperatureInF) {
		this.temperatureInC = fToC(temperatureInF);
	}

	//Methods to convert fahrenheit and celcius to one another
	private double fToC(double f) {
		return ((f - 32) * 5 / 9);
	}

	private double cToF(double c) {
		return ((c * 9 / 5) + 32);
	}

}
