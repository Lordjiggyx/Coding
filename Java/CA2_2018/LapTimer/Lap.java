package LapTimer;


public class Lap {

	private int id;
	private float lapTime;
	
	public Lap(int id, float lapTime) {

		this.id = id;
		this.lapTime = lapTime;
	
	}
//Getter and Setter Method for the id and lap time
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getLapTime() {
		return lapTime;
	}

	public void setLapTime(float lapTime) {
		this.lapTime = lapTime;
	}
	
	
	

}
