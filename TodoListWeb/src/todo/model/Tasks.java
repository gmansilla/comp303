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

	public boolean addTask(Task newtask) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(newtask);
		et.commit();
		em.close();
		return true;
	}

	public void updateTask(Task task) {
		// not implemented
	}

	public void deleteTask(int taskId) {
		// not implemented
	}

	public List<Task> viewAllTasks(int userId) {
		
		EntityManager em = emf.createEntityManager();
		Query q = em.createNamedQuery("Task.findTasksByUserId");
		q.setParameter("userId", userId);
		List<Task> taskList = q.getResultList();
		tasks = new ArrayList<Task>();
		for (Task t : taskList) {
			tasks.add(t);
		}
		em.close();

		return tasks;
	}

	public List<Task> viewPendingTasks(int userId) {
		return null;
	}

	public List<Task> viewTasksByPriority(int userId, char priorityValue) {
		return null;
	}

	public void markAsDone(int taskId) {
		// not implemented
	}

	public Task viewTaskDetails(int taskId) {
		return null;
	}

	public void startTask(int taskId) {
		// not implemented
	}

	public void endTask(int taskId) {
		// not implemented
	}

	public int getPendingTasksCount(int userId) {
		return 0;
	}

	public int getTotalTasksCount(int userId) {
		return 0;
	}

	public int getFinishedTasksCount(int userId) {
		return 0;
	}

}
