package todo.model;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import todolist.entities.User;

public class Users {

private static User user = null;
private static EntityManagerFactory emf = null;
final String salt = "password";
	
	public Users() {

		if (emf == null) {
			InitialContext ctx;
			try {
				ctx = new InitialContext();
				emf = (EntityManagerFactory) ctx.lookup("java:/TodoListEMF");
			} catch (NamingException e) {
				e.printStackTrace();
			}

		}
	}
	
	public User getUser(String email) {
		
		EntityManager em = emf.createEntityManager();
		Query q = em.createNamedQuery("User.findUser");
		q.setParameter("email", email);
		List<User> users = q.getResultList();
		for (User u : users) {
			// assuming only one row is returned
			user = u;
		}
		em.close();

		return user;

	}

	public User loginUser(User user) {
		
		User userFromDB = getUser(user.getEmail());
		if (userFromDB == null) {
			return null;
		}
		if (userFromDB.getPassword().equals(user.getPassword())) {
			return userFromDB;
		}
		return null;
	}
	
	public boolean logoutUser(User user) {
		return false;
	}
	
}
