
//This is an example of an object adapter as you can see
//IT IMPLEMEMTS THE TARGET INTERFACE
public class TemperatureObjectReporter implements TemperatureInfo {
	//BUT ALSO HERE WE HAVE IT USING THE ADAPTEE CLASS AS ITS ATTRIBUTE
	CelciusReporter celciusReporter;

	//In this type of adapter we create an instance of our adaptee in the constructor
	public TemperatureObjectReporter() {
		celciusReporter = new CelciusReporter();
	}

	@Override
	//Uses the method from the adaptee class calling it from the adaptee object
	public double getTemperatureInC() {
		return celciusReporter.getTemperature();
	}

	@Override
	//This method is taken from the interface and it returns the value of temperature in fahrenheit as it is converted from C to F but calls the getter from the adpatee object
	public double getTemperatureInF() {
		return cToF(celciusReporter.getTemperature());
	}

	@Override
	//Uses the method from the adaptee class calling it from the adaptee object
	public void setTemperatureInC(double temperatureInC) {
	celciusReporter.setTemperature(temperatureInC);
	}

	@Override
	//This method is taken from the interface and it returns the value of temperature in fahrenheit as it is converted from C to F but calls the setter from the adpatee object

	public void setTemperatureInF(double temperatureInF) {
		celciusReporter.setTemperature(fToC(temperatureInF));
	}

	//Methods to convert fahrenheit and celcius to one another
	private double fToC(double f) {
		return ((f - 32) * 5 / 9);
	}

	private double cToF(double c) {
		return ((c * 9 / 5) + 32);
	}

}
