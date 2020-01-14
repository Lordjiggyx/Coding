/*
 * VideoLibrary class - this is the main class which contains the code
 * to add, delete and display videos in a queue.
 * 
* Student Name Tomi Ilori:
 * Student Number C16359881: 
 * Date  04/12/2017:    
 */

package application;

import java.util.Scanner;
import dataStructures.*;

public class VideoLibrary {
    
    final int DEFAULT_CAPACITY = 10;
    ArrayQueue<Video> theVideoLibrary; 
    
    public VideoLibrary() {
        theVideoLibrary = new ArrayQueue<Video>(DEFAULT_CAPACITY);
    } // end constructor 
    
    
    /* Displays the menu and asks the user to input a menu option
    * If the user inputs any value except 1 to 4, an error message
    * will be displayed 
    */
    public char menuOption() {
    
          	 String option = "";
             Scanner scan = new Scanner(System.in); 
                
            
             System.out.println("1. Return a video to the library (i.e. add a video)");
             System.out.println("2. Borrow a video from the library (i.e. delete a video)");
             System.out.println("3. Display all videos in the library");
             System.out.println("4. Exit Program");
        
             System.out.print("\n\n Please input your desired menu option : ");
             option = scan.nextLine();
             if (option.length() == 1) 
                 if (option.charAt(0) >= '1' && option.charAt(0) <= '4') { 
                     if (option.charAt(0) == '1')
                         returnVideo();
                     else if (option.charAt(0) == '2')
                         borrowVideo();
                     else if (option.charAt(0) == '3')
                         	displayVideos();
                     else if (option.charAt(0) == '4')
                         System.out.println("Video library closing ....");
                 }   
               else {
                   System.out.println("Error - No such menu option");
             	   System.out.println("\n");
                   return '0';
               }	   
             	// this means that the menu won't be displayed 
             	// again until the user hits the return key
             	System.out.println("Press the return key to continue...");
             	String delay = scan.nextLine();
                return option.charAt(0);
       
       
    } //end menuOption
    
    
    
    /************ BORROW A VIDEO ***********************/
    /* This method allows the user to borrow a video. 
     */  
    public void borrowVideo() {
    	Scanner scan = new Scanner(System.in);
    	
        System.out.println("Borrow a video ....");
       if(theVideoLibrary.isEmpty())
       {
    	   System.out.println("There are no videos avaliable come back later");
       }
       else
       {
    	   System.out.println("This video"+ " "+ theVideoLibrary.first().getTitle()+ " " + "will now be borrowed");
    	   theVideoLibrary.dequeue();   
       }
    } //end borrowVideos

    
    /**************** RETURN A VIDEO***********************/
    /* This method allows the user to return a borrowed video assuming
     * that there are not already 10 videos returned.
    */
    public void returnVideo() {
        System.out.println("Return a video....");
        // ADD CODE HERE
        if(theVideoLibrary.size() == 10)
        {
        	 System.out.println("All Videos Have Been Returned will be returned");
        }
        else
        {
        	Scanner scan = new Scanner(System.in);
        	String videoTitle , rating;
        	
        	 System.out.println("Hello User please Enter Video Details as Requested");
        	 System.out.println("What is the video name?");
        	 videoTitle = scan.nextLine();
        	 System.out.println("What is the video rating?");
        	 rating = scan.nextLine();
        	 
        	 Video aVideo = new Video(videoTitle , rating);
        	 
        	 theVideoLibrary.enqueue(aVideo);
        	 
        	 System.out.println("Video has been returned successfully");
        }
      } //end returnVideo  


    /********** DISPLAY ALL VIDEOS ********************/
   /* This method displays all videos by displaying the video at the 
    * front of the queue, copying it to a temporary queue and            
    * repeating this action until all videos have been displayed. 
     * Then the contents of the temporary
    * queue are copied back to the main queue. 
    */
    
     public void displayVideos() {
        System.out.println("\n\nDisplay all videos....");
        ArrayQueue<Video> theVideoLibrary1; 
    	theVideoLibrary1 = new ArrayQueue<Video>(DEFAULT_CAPACITY);
       
        // ADD CODE HERE
        if(theVideoLibrary.isEmpty())
        {
     	   System.out.println("There are no videos avaliable come back later");
        }
        else
        {
        	do
        	{
        		if(theVideoLibrary.isEmpty())
            	{
            		System.out.println("All Items Copied Over to array 1");
            	}
        		else
        		System.out.println(theVideoLibrary.first().toString());
        		theVideoLibrary1.enqueue(theVideoLibrary.first());
        		theVideoLibrary.dequeue();
        	}while(!theVideoLibrary.isEmpty());
        	
        	do
        	{
        		if(theVideoLibrary1.isEmpty())
            	{
            		System.out.println("All Items Copied Over to array 1");
            	}
        		theVideoLibrary.enqueue(theVideoLibrary1.first());
        		theVideoLibrary1.dequeue();
        	}while(!theVideoLibrary1.isEmpty());
        }
     
    	
    	
    } //end displayVideos

     
    
    
    // This is the main method code.
    public static void main ( String[] args)
    {
      
      VideoLibrary myLibrary = new VideoLibrary();
      
      // keep looping until the user indicates that they wish to exit 
      // the program
      while (myLibrary.menuOption() != '4');
      
    }//end main
} //end VideoLibrary
