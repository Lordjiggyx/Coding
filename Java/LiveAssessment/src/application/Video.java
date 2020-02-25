/*
 * Video class - this describes the structure and behaviour

 * of a video.
 * 
 * Student Name Tomi Ilori:
 * Student Number C16359881: 
 * Date  04/12/2017:  
 */
package application;

public class Video {
    private String videoTitle;
    private String rating;
    
    
    public Video() {
      this.videoTitle = "";
      this.rating = "";
    }
    
    
	   
    public Video (String t, String r) {
       // ADD CODE HERE
       //1. Update the videoTitle to the parameter value
    	this.videoTitle = t;
       //2. If the parameter value for rating is incorrect
       // (i.e. not "novice" or "expert"), then set the rating 
       //to Error otherwise set it to the parameter value
    	if(!r.equalsIgnoreCase("novice") && !r.equalsIgnoreCase("expert") )
    	{
    		this.rating = "ERROR";
    	}
    	else
    		this.rating = r;
    }		
    
    //getter methods
    public String getTitle() {
        return this.videoTitle; 
    }
    
    public String getRating() {
        return this.rating;
    }
 
	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}



	// generate a string representation of a video
    public String toString() {
        // ADD CODE HERE
      return "This Video," + this.videoTitle +  " Requires" + " "+ this.rating + " "+ "attention";
    }
}// end Video


