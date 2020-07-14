package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Entities.Profile;

public class ProfileDAO {

	protected static EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("TPU"); 	
	
	public ProfileDAO() {
		
	}
	
	public void persistProfile(Profile profile) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(profile);
		em.getTransaction().commit();
		em.close();
	}
	
	//calling Profile and getting the list of All Profiles
	public List<Profile> getAllProfiles(){
		EntityManager em = emf.createEntityManager();
		List<Profile> profile = (List<Profile>)em.createNamedQuery("Profile.findAll").getResultList();
		em.close();
		return profile;
	}
	
	//calling Profile namedQuery reuest and getting the Profile with tat desc
	public Profile getProfileByDescription(String description){
		EntityManager em = emf.createEntityManager();
		//setParameter("description") this is where variable is called in the parm of Profile NamedQuery
		List<Profile> profile = (List<Profile>)em.createNamedQuery("Profile.findByDescription").setParameter("description", description).getResultList();
		em.close();
		
		//Get first profile with that description 
		Profile pro = new Profile();
		for(Profile p: profile){
			pro = p;
		}
		return pro;	
	}
	

	
	public void mergeProfile(Profile profile){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Profile updatedProfile = em.merge(profile);
		em.getTransaction().commit();
		em.close();
	}
	
	public void removeProfile(Profile profile){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(profile);
		em.getTransaction().commit();
		em.close();
		
	}
	

}
