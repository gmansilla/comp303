package todo.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import todolist.entities.User;

public class Users {

private static EntityManagerFactory emf = null;
final String salt = "password";
	
	/**
	 * public constructor 
	 */
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
	
	/**
	 * Gets an user given their email
	 * @param email
	 * @return User
	 */
	public User getUser(String email) {
		EntityManager em = emf.createEntityManager();
		Query q = em.createNamedQuery("User.findUser");
		q.setParameter("email", email);
		List<User> users = q.getResultList();
		if (users.size() < 1) {
			return null;
		}
		User user = (User)users.get(0);
		em.close();
		return user;
	}

	/**
	 * Checks if a given user is able to log in.
	 * Passwords are not stored in plain text but with a hash, this hash is constructed
	 * using a salt defined in this class.
	 * @param user
	 * @return User
	 */
	public User loginUser(User user) {
		String password = null;
		try {
			password = sha1(salt + user.getPassword());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		User userFromDB = getUser(user.getEmail());
		if (userFromDB == null) {
			return null;
		}
		if (userFromDB.getPassword().equals(password)) {
			return userFromDB;
		}
		return null;
	}
	
	/**
	 * Calculates the SHA1 of a given string
	 * @param input
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	private String sha1(String input) throws NoSuchAlgorithmException {
        MessageDigest mDigest = MessageDigest.getInstance("SHA1");
        byte[] result = mDigest.digest(input.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
}
