package todo.model;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;

import todolist.entities.User;

public class Users {

private static User user = null;
private static EntityManagerFactory emf = null;
	
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

	public boolean loginUser(User user) {
		
		User userFromDB = getUser(user.getEmail());
		if (userFromDB == null) {
			return false;
		}
		if (userFromDB.getPassword().equals(user.getPassword())) {
			return true;
		}
		return false;
	}
	
	public boolean logoutUser(User user) {
		return false;
	}
	
}
