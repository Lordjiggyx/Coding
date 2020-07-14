package WeatherApp;


import java.util.*;

public class WeatherData implements WeatherSubject{

	
		//This variables are the state of the subject 
        private float temperature;
        private float humidity;
        private float pressure;
       
        //Variable representing the list of observers
        ArrayList<WeatherObserver> obs = new ArrayList<WeatherObserver>();
        
        
        public WeatherData() {

        }
       
        //In this case this will be like our do notify which will esstentially go through each observer in the collection of observer objects
        public void measurementsChanged() {
                for(WeatherObserver o :obs)
                {
                	//call the update method
                	o.update(this.temperature , this.humidity , this.pressure);
                }
        }
       
        public void setMeasurements(float temperature, float humidity, float pressure) {
                this.temperature = temperature;
                this.humidity = humidity;
                this.pressure = pressure;
                doNotify();
        }
       
        public float getTemperature() {
                return temperature;
        }
       
        public float getHumidity() {
                return humidity;
        }
       
        public float getPressure() {
                return pressure;
        }

		@Override
		public void addOb(WeatherObserver o) {
			// TODO Auto-generated method stub
			obs.add(o);
		}

		@Override
		public void removeOb(WeatherObserver o) {
			// TODO Auto-generated method stub
			obs.remove(o);
		}

		//this will just call the measurements changed method
		@Override
		public void doNotify() {
			// TODO Auto-generated method stub
			measurementsChanged();
		}
}

