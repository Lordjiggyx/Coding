public class BridgeDemo {

	public static void main(String[] args) {
		//Here we define a vehicle and allow it to be a big bus with a small engine
		Vehicle vehicle = new BigBus(new SmallEngine());
		vehicle.drive();
		//Here we chnage the engine to a big engine 
		vehicle.setEngine(new BigEngine());
		vehicle.drive();

		//now we change the vehicle to be a small car with a small engine
		vehicle = new SmallCar(new SmallEngine());
		vehicle.drive();
		//Here we change the engine to a big engine 
		vehicle.setEngine(new BigEngine());
		vehicle.drive();

		//THIS IS ALL HAPPNEING AT RUN TIME ALLOWING IT TO BE VERY FLEXIBLE
	}
}