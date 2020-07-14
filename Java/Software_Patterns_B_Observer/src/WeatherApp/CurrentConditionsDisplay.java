package WeatherApp;

public class CurrentConditionsDisplay implements WeatherObserver {
        private float temperature;
        private float humidity;
        private WeatherSubject weatherData;
       
        public CurrentConditionsDisplay(WeatherSubject weatherData) {
                this.weatherData = weatherData;
                weatherData.addOb(this);
        }
       
        public void update(float temperature, float humidity, float pressure) {
                this.temperature = temperature;
                this.humidity = humidity;
                display();
        }
       
        public void display() {
                System.out.println("Current conditions: " + temperature
                        + "F degrees and " + humidity + "% humidity");
        }
}

