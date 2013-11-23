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

	public Task viewTaskDetails(int taskId) {
		return null;
	}

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

	public List<Task> getPendingTasks() {
		EntityManager em = emf.createEntityManager();
		Query q = em.createNamedQuery("Task.getPendingTasks");
		List<Task> taskList = q.getResultList();
		tasks = new ArrayList<Task>();
		for (Task t : taskList) {
			tasks.add(t);
		}
		em.close();

		return tasks;
	}
	
	public int getPendingTasksCount(int userId) {
		return 12;
	}

	public int getTotalTasksCount(int userId) {
		return 100;
	}

	public int getFinishedTasksCount(int userId) {
		return 88;
	}

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
