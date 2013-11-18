package todo.model;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;

import todolist.entities.Task;

public class Tasks {
	
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
	
	public void addTask(Task task) {
		// not implemented
	}
	
	public void updateTask(Task task) {
		// not implemented
	}
	
	public void deleteTask(int taskId) {
		// not implemented
	}
	
	public List<Task> viewAllTasks(int userId) {
		return null;
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
