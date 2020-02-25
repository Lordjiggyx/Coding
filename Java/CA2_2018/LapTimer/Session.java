package LapTimer;

import java.util.Collections;
import java.util.Vector;

import javax.swing.JOptionPane;

public class Session {
	//Lap variables to store the fastest and slowest lap
	Lap FastestLap;
	Lap SlowestLap;
	Vector<Lap> laps = new Vector<Lap>();
	public Session() {

		laps = new Vector<Lap>();

	}
	
	public void addLap(Lap l) 
	{
		
		laps.add(l);
		
	}
	
	public float calculateAverageTime() 
	{
		
		/* This method should calculate the
		   average time of all laps in the 
		   collection. It needs to return a 
		   float value */
	
		//Sum variable to be the total lap times combined
		float sum = 0 ; 
		//variable to store average
		float ave;
		
		//Loop to go through the vector of laps
		for(int i = 0; i< laps.size(); i++)
		{
			//each lap is added to the sum variable
			sum = sum + laps.get(i).getLapTime();
		}
		//avaerage is obtained by dividing the total by the size of the vector
		ave = sum/laps.size();
		return ave;
	}
	
	
	public Lap getFastestLap()
	{
		
		/* This method should step through the
		   collection, and return the Lap object
		   whose lap time is smallest (fastest). */
		
		//Lap being declared to be used as a placeholder
		Lap aLap ;
		Lap bLap;
		
		//If there is only one lap the only lap is set to the fastest lap
		if(laps.size() == 1)
		{
			FastestLap =new Lap(laps.get(0).getId() , laps.get(0).getLapTime());
		
			
		}		
		//If there is only two laps the first two are compared
		if(laps.size() == 2)
		{
			//Both laps are initialised to the corresponding first and second lap
			aLap = new Lap( laps.get(0).getId() , laps.get(0).getLapTime());
			bLap = new Lap( laps.get(1).getId() , laps.get(1).getLapTime());
			//if the first lap is faster then the secind the first lap is set to the fastest
			if(aLap.getLapTime() < bLap.getLapTime())
			{
				FastestLap = aLap;
			}
			//else the second lap is set to the fastest lap
			else
			{
				FastestLap = bLap;
			}
			
		}
		else
			//if there is more than two laps the the vector is then traversed to find the fastest lap
		{
			//Lap is initialized
			aLap = new Lap( laps.get(0).getId() , laps.get(0).getLapTime());
			//Vector is traversed 
			for(int i= 0 ; i <laps.size();i++)
			{
				//if the lap coming in is faster than the first lap
				if(laps.get(i).getLapTime() < aLap.getLapTime())
				{
					//The time and id are set to this incoming lap
					aLap.setLapTime(laps.get(i).getLapTime());
					aLap.setId(laps.get(i).getId());
					//Then the fastest lap is set to this lap
					FastestLap = aLap;
				}
				else
					//if the first lap is the fastest it is then set to fastest lap
				{
					FastestLap = aLap;
				}
				
			}
			
			
		}
		return FastestLap;
	}
	
	public Lap getSlowestLap() 
	{
		
		/* This method should step through the
		   collection, and return the Lap object
		   whose lap time is largest (slowest). */
		
		//The logic behind this method is the same as the faster one just the sign is switched around to check of the lap is slowest
		Lap aLap ;
		Lap bLap;;
		if(laps.size() == 1)
		{
			SlowestLap =new Lap(laps.get(0).getId() , laps.get(0).getLapTime());
		}
	
		if(laps.size() == 2)
		{
			aLap = new Lap( laps.get(0).getId() , laps.get(0).getLapTime());
			bLap = new Lap( laps.get(1).getId() , laps.get(1).getLapTime());
			if(aLap.getLapTime() > bLap.getLapTime())
			{
				SlowestLap = aLap;
			}
			else
			{
				SlowestLap = bLap;
			}
			
		}
		else	
		{
			aLap = new Lap( laps.get(0).getId() , laps.get(0).getLapTime());
			for(int i= 0 ; i <laps.size();i++)
			{
			
				if(laps.get(i).getLapTime()> aLap.getLapTime())
				{
					aLap.setLapTime(laps.get(i).getLapTime());
					aLap.setId(laps.get(i).getId());
					SlowestLap = aLap;
				}
				else
				{
					SlowestLap = aLap;
				}
			}
		}
		return SlowestLap;
	}
	

//method to get the size of the vector
public int getSize()
{
	return laps.size();
}



}
