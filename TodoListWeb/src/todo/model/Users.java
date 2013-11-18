package todo.model;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;

import todolist.entities.User;

public class Users {

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
	
	public boolean loginUser(User user) {
		return false;
	}
	
	public boolean logoutUser(User user) {
		return false;
	}
	
}
