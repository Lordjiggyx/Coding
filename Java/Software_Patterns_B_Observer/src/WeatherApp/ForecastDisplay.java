
package WeatherApp;

import java.util.*;

public class ForecastDisplay implements WeatherObserver {
        private float currentPressure = 29.92f;  
        private float lastPressure;
        private WeatherSubject weatherData;

        public ForecastDisplay(WeatherSubject weatherData) {
                this.weatherData = weatherData;
                weatherData.addOb(this);
        }

        public void update(float temp, float humidity, float pressure) {
                lastPressure = currentPressure;
                currentPressure = pressure;

                display();
        }

        public void display() {
                System.out.print("Forecast: ");
                if (currentPressure > lastPressure) {
                        System.out.println("Improving weather on the way!");
                } else if (currentPressure == lastPressure) {
                        System.out.println("More of the same");
                } else if (currentPressure < lastPressure) {
                        System.out.println("Watch out for cooler, rainy weather");
                }
        }
}