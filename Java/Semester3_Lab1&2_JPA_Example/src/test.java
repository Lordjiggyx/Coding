import java.util.ArrayList;
import java.util.List;

import DAO.CommentDAO;
import DAO.ProfileDAO;
import DAO.SubscriberDAO;
import Entities.Comment;
import Entities.Profile;
import Entities.Subscriber;

public class test {

	public test()  {
		
		CommentDAO cdao = new CommentDAO();
		Comment comment = new Comment("Tomi is the one");

		cdao.persistComment(comment);

		
		ProfileDAO pdao = new ProfileDAO();
		Profile profile = new Profile("This Is Tomi3's Profile" );
		profile.addComments(comment);
		pdao.persistProfile(profile);
		
		SubscriberDAO subscriberdao = new SubscriberDAO();
		Subscriber subscriber = new Subscriber("Tomi3", "Winer2018" ,profile);
		
		subscriberdao.persistSubscriber(subscriber);
		
		//calling the list of Subscribers to get All
				List<Subscriber> subscribers = new ArrayList<Subscriber>();
				subscribers = subscriberdao.getAllSubscribers();
				
				//return the list of Subscribers
				
				
				//this is where setting the username to return back Tomiilori 
				Subscriber name = subscriberdao.getSubscriberByUsername("Tomi");
//				System.out.println("Is this Tomi? "+ name.getUsername());
				
//				
//				Subscriber update = subscriberdao.UpdateByUsername("John Doe", "Bobby");
//				System.out.println("Tomiilori has been changed to Tom");
//				
				
				
//				subscribers = subscriberdao.getAllSubscribers();
//				for(Subscriber s: subscribers){
//					System.out.println("List of Subscribers from DB " + s.getUsername());
//				}
//				
//			//call the list of Profile
				List<Profile> profiles = new ArrayList<Profile>();
				profiles = pdao.getAllProfiles();
//				
//				//return the list of Profile to get All
				for(Profile p: profiles){
					System.out.println("List of Profiles from DB: " + p.getDescription());
				}
				
				List<Comment> comments = new ArrayList<Comment>();
				comments = cdao.getAllComments();
//				
//				//return the list of Comments to get All
				
				for(Comment c: comments) {
					System.out.println("List of Comments from DB: " + c.getDescription());
			}
			
//				for(Profile p: profiles)
//				{	
//					for(Comment c: comments)
//					{
//					p.removeComments(c);
//					cdao.removeComment(c);
//					comments.remove(c);
//					}
//				 
//				for(Comment c: comments) {
//					System.out.println("List of Comments from DB: " + c.getDescription());
//			}
//				}
				
//				//return the list of Profile with the Description with "This is a prfoile"
//				Profile descript = pdao.getProfileByDescription("This is a profile");
//				System.out.println("Who said high: " + descript.getDescription());
//				
//			//call the list of Comments to get All
//				List<Comment> comments = new ArrayList<Comment>();
//				comments = cdao.getAllComments();
////				
////				//return the list of Comments to get All
//				for(Comment c: comments) {
//					System.out.println("List of Comments from DB: " + c.getDescription());
//				}
//				
//				//this is where setting which comment you want back 
//				Comment content = cdao.getCommentByContent("Hey Tomi");
//				System.out.println("Response is: " + content.getDescription());
//				
//				for(Subscriber s: subscribers){
//					
//					subscribers.remove(s);
//					subscriberdao.removeSubscriber(s);
//				}
//				
//			
//				for(Subscriber s: subscribers){
//					System.out.println("List of Subscribers from DB " + s.getUsername());
//				}
				
//				remove comment from profile
//				then update the profile with the removed comment
//				then get the comment
//				and then reomve it from the database
	}
	
	public static void main(String[] args) {
		new test();
	}

}
