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
			if (request.getParameter("logout") != null) {
				session.invalidate();
			}
			RequestDispatcher rd = request.getRequestDispatcher("login");
			rd.forward(request, response);
		} else {
			// if logged in, show dashboard
			// fetch all the tasks
			int userId = Integer.parseInt(session.getAttribute("userId")
					.toString());
			Tasks tasks = new Tasks();
			List<Task> taskList = tasks.viewAllTasks(userId);
			System.out.println("adding tasks list " + taskList.size());
			// Get pending tasks
			int pendingTasksCount = tasks.getPendingTasksCount(userId);
			int totalTasks = tasks.getTotalTasksCount(userId);
			int finishedTasks = tasks.getFinishedTasksCount(userId);

			// show the page
			request.setAttribute("taskList", taskList);
			request.setAttribute("pendingTaskCount", pendingTasksCount);
			request.setAttribute("totalTasks", totalTasks);
			request.setAttribute("finishedTasks", finishedTasks);
			RequestDispatcher rd = request
					.getRequestDispatcher("/dashboard.jsp");
			rd.forward(request, response);
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
			// if logged in, show dashboard

			// fetch all the tasks
			int userId = Integer.parseInt(session.getAttribute("userId")
					.toString());
			Tasks tasks = new Tasks();
			List<Task> taskList = tasks.viewAllTasks(userId);

			// Get pending tasks
			int pendingTasksCount = tasks.getPendingTasksCount(userId);
			int totalTasks = tasks.getTotalTasksCount(userId);
			int finishedTasks = tasks.getFinishedTasksCount(userId);

			// show the page
			request.setAttribute("taskList", taskList);
			request.setAttribute("pendingTaskCount", pendingTasksCount);
			request.setAttribute("totalTasks", totalTasks);
			request.setAttribute("finishedTasks", finishedTasks);
			RequestDispatcher rd = request
					.getRequestDispatcher("/dashboard.jsp");
			rd.forward(request, response);
		}
	}

}
