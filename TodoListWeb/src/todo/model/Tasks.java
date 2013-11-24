package todo.model;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import todolist.entities.Task;
import todolist.entities.User;

public class Tasks {

	private static Task task = null;
	private static List<Task> tasks = null;
	private static EntityManagerFactory emf = null;

	/**
	 * Public constructor
	 */
	public Tasks() {
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
	 * Adds a new Task to database
	 * @param newtask
	 * @return
	 */
	public boolean addTask(Task newtask) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(newtask);
		et.commit();
		em.close();
		return true;
	}

	/**
	 * Updates a given Task
	 * @param task
	 * @return
	 */
	public boolean updateTask(Task task) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(task);
		et.commit();
		em.close();
		return true;
	}

	/**
	 * Modifies the status of a Task
	 * @param taskId
	 * @param status
	 */
	public void modifyStatus(int taskId, String status) {
		Task task = getTask(taskId);
		if (task == null) {
			return;
		}
		task.setStatus(status);
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(task);
		et.commit();
		em.close();
	}

	/**
	 * Gets a list of Tasks given a filter. The filter can take one of these names:
	 * "all", "finished" or "pending"
	 * @param userId
	 * @param status
	 * @return
	 */
	public List<Task> getTasksByStatus(int userId, String status) {
		EntityManager em = emf.createEntityManager();
		Query q = null;
		if (status.equals("all")) {
			q = em.createNamedQuery("Task.findTasksByUserId");
		} else if (status.equals("finished")) {
			q = em.createNamedQuery("Task.getFinishedTasksByUserId");
		} else if (status.equals("pending")) {
			q = em.createNamedQuery("Task.getPendingTasksByUserId");
		}
		q.setParameter("userId", userId);
		List<Task> taskList = q.getResultList();
		tasks = new ArrayList<Task>();
		for (Task t : taskList) {
			tasks.add(t);
		}
		em.close();
		return tasks;
	}
	
	/**
	 * Gets a Task given its id
	 * @param taskId
	 * @return
	 */
	public Task getTask(int taskId) {
		EntityManager em = emf.createEntityManager();
		Query q = em.createNamedQuery("Task.findTaskById");
		q.setParameter("taskId", taskId);
		List result = q.getResultList();
		if (result.size() < 1) {
			return null;
		}
		Task task = (Task)q.getResultList().get(0);
		return task;
	}
}
