package todo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import todo.model.Tasks;
import todolist.entities.Task;

/**
 * Servlet implementation class DashboardServlet
 */
@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DashboardServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet Dashboard Servlet ");
		HttpSession session = request.getSession();
		if (session.getAttribute("useremail") == null
				|| session.getAttribute("useremail").equals("")) {
			// if not logged in, redirect to login page
			
			RequestDispatcher rd = request.getRequestDispatcher("login");
			rd.forward(request, response);
		} else {
			loadDashboard(request, response, Integer.parseInt(session.getAttribute("userId")
					.toString()));
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost Dashboard Servlet ");
		HttpSession session = request.getSession();
		if (session.getAttribute("useremail") == null
				|| session.getAttribute("useremail").equals("")) {
			// if not logged in, redirect to login page
			RequestDispatcher rd = request.getRequestDispatcher("login");
			rd.forward(request, response);
		} else {
			loadDashboard(request, response, Integer.parseInt(session.getAttribute("userId")
					.toString()));
		}
	}
	
	private void loadDashboard(HttpServletRequest request, HttpServletResponse response, Integer userId) throws ServletException, IOException {
		if (userId == null) {
			return;
		}
		Tasks tasks = new Tasks();
		List<Task> taskList = tasks.getTasksByStatus(userId, "all"); //all tasks
		List<Task> tasksPending = tasks.getTasksByStatus(userId, "pending"); //all pending tasks
		List<Task> tasksFinished = tasks.getTasksByStatus(userId, "finished"); //all pending tasks
		
		// Get pending tasks
		int pendingTasksCount = tasksPending.size();
		int totalTasksCount = taskList.size();
		int finishedTasksCount = tasksFinished.size();

		// show the page
		request.setAttribute("taskList", taskList);
		request.setAttribute("pendingTasksCount", pendingTasksCount);
		request.setAttribute("totalTasksCount", totalTasksCount);
		request.setAttribute("finishedTasksCount", finishedTasksCount);
		RequestDispatcher rd = request
				.getRequestDispatcher("/dashboard.jsp");
		rd.forward(request, response);
		
	}

}
