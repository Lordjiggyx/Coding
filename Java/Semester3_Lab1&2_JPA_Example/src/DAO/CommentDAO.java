package DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Entities.Comment;


public class CommentDAO {

	protected static EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("TPU"); 	

	public CommentDAO() {
		// TODO Auto-generated constructor stub
	}

	public void persistComment(Comment comment) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(comment);
		em.getTransaction().commit();
		em.close();
	}
	
	//is to update the DB and to return the updated version
		public void mergeComment(Comment comment){
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.merge(comment);
			em.getTransaction().commit();
			em.close();
			
			//return updatedComment;
		}
		
		
		public void removeComment(Comment comment){
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.remove(em.merge(comment));
			em.getTransaction().commit();
			em.close();
		}
		
		public void removeCommentByDescription(String desc)
		{
			EntityManager em = emf.createEntityManager();
			List<Comment> comments = (List<Comment>)
					em.createNamedQuery("Comment.findByComments").setParameter("description", desc).getResultList();
			
			Comment com = new Comment();
			for(Comment c: comments) {
				com=c;
			}
			
			em.getTransaction().begin();
			em.remove(com);
			em.getTransaction().commit();
			em.close();
		}

		public List<Comment> getAllComments() {
			// TODO Auto-generated method stub
			EntityManager em = emf.createEntityManager();
			//calling the method nameQuery of what is in Comment class
			List<Comment> comments = (List<Comment>)em.createNamedQuery("Comment.findAll").getResultList();
			em.close();
			return comments;
		}

		public Comment getCommentByContent(String description) {
			// TODO Auto-generated method stub
			EntityManager em = emf.createEntityManager();
			List<Comment> comments = (List<Comment>)
					em.createNamedQuery("Comment.findByComments").setParameter("description", description).getResultList();
			em.close();
			
			//Get the first comment with that content
			Comment com = new Comment();
			for(Comment c: comments) {
				com=c;
			}
			return com;
		}
		
//		public List<Comment> getCommentsByid(int id) {
//			// TODO Auto-generated method stub
//			EntityManager em = emf.createEntityManager();
//			List<Comment> comments = (List<Comment>)
//					em.createNamedQuery("Comment.findCommentsByUserId").setParameter("profile_id", id).getResultList();
//			em.close();
//			
//			//Get the first comment with that content
//			return comments;
//		}
}