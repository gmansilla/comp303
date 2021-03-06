package todo.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import todo.model.Tasks;
import todolist.entities.Task;
import todolist.entities.User;

/**
 * Servlet implementation class TodoServlet
 */
@WebServlet("/tasks")
public class TodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TodoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String responsePage = "/addtask.jsp";
		String id = request.getParameter("id"); // check if Edit action is being
												// called. It doesn't matter we
												// treat this as a string here.
		String status = request.getParameter("status");
		Date dt = new Date();
		
		if (id == null) {
			// add new task
			String newstring = new SimpleDateFormat("yyyy-MM-dd").format(dt);
			request.setAttribute("dt", newstring);
			RequestDispatcher rd = request.getRequestDispatcher(responsePage);
			rd.forward(request, response);
			return;
		} else if (status == null) {
			// edit task page
			int taskId = Integer.parseInt(id);
			Tasks tasks = new Tasks();
			Task task = tasks.getTask(taskId);
			String newstring = new SimpleDateFormat("yyyy-MM-dd").format(task.getDueDate());
			request.setAttribute("dt", newstring);
			request.setAttribute("task", task);
			RequestDispatcher rd = request.getRequestDispatcher(responsePage);
			rd.forward(request, response);
			return;
		} else if (status.equals("d")) {
			// delete task
			int taskId = Integer.parseInt(id);
			Tasks tasks = new Tasks();
			tasks.deleteTask(taskId);
			responsePage = "dashboard";
		} else {
			// => id!=null and status!=null
			// change status of that task
			responsePage = "dashboard";
			Tasks task = new Tasks();
			task.modifyStatus(Integer.parseInt(id), status);

		}
		RequestDispatcher rd = request.getRequestDispatcher(responsePage);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		// read values from the form
		String taskId = request.getParameter("taskId");
		String taskName = request.getParameter("taskName");
		String taskDesc = request.getParameter("taskDesc");
		String priority = request.getParameter("taskPriority");
		String status = request.getParameter("taskStatus");
		String taskDate = request.getParameter("inputDate");

		// convert string to date object
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dueDate = null;
		try {
			dueDate = dateFormat.parse(taskDate);
		} catch (ParseException e) {
			System.out.println(e.getMessage());

		}

		Date dateCreated = new Date();

		User u = new User();
		u.setId(Integer.parseInt(session.getAttribute("userId").toString()));

		// create task object
		Task newTask = new Task();
		newTask.setName(taskName);
		newTask.setUser(u);
		newTask.setDescription(taskDesc);
		newTask.setPriority(priority);
		newTask.setStatus(status);
		newTask.setCreated(dateCreated);
		newTask.setDueDate(dueDate);

		Tasks tasks = new Tasks();
		if(taskId == null || taskId.equalsIgnoreCase("")) {
			if (tasks.addTask(newTask)) {
				RequestDispatcher rd = request.getRequestDispatcher("dashboard");
				rd.forward(request, response);
			} else {
				request.setAttribute("message", "You need to provide a name");
				RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
				rd.forward(request, response);
			}	
			// if taskId is not there add
		} else {
			// if taskId is there update
			newTask.setId(Integer.parseInt(taskId));
			if (tasks.updateTask(newTask)) {
				RequestDispatcher rd = request.getRequestDispatcher("dashboard");
				rd.forward(request, response);
			}
		}

	}

}
