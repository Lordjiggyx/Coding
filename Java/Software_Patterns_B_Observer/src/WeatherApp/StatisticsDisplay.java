
package WeatherApp;

import java.util.*;

public class StatisticsDisplay implements WeatherObserver {
        private float maxTemp = 0.0f;
        private float minTemp = 200;
        private float tempSum= 0.0f;
        private int numReadings;
        private WeatherSubject weatherData;

        public StatisticsDisplay(WeatherSubject weatherData) {
                this.weatherData = weatherData;
                weatherData.addOb(this);
        }

        public void update(float temp, float humidity, float pressure) {
                tempSum += temp;
                numReadings++;

                if (temp > maxTemp) {
                        maxTemp = temp;
                }
 
                if (temp < minTemp) {
                        minTemp = temp;
                }

                display();
        }

        public void display() {
                System.out.println("Avg/Max/Min temperature = " + (tempSum / numReadings)
                        + "/" + maxTemp + "/" + minTemp);
        }
}
