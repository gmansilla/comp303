package todo.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String responsePage = "/addtask.jsp";
		String id = request.getParameter("id"); //check if Edit action is being called. It doesn't matter we treat this as a string here.
		if (id != null) {
			//TODO get the current data assigned to that Task and load the values in the form
			if (request.getParameter("status") != null) { 
				Tasks tasks = new Tasks();
				tasks.endTask(Integer.parseInt(id));
				RequestDispatcher rd = request.getRequestDispatcher("dashboard");
				rd.forward(request, response);
				return;
			}
		} 
		
		RequestDispatcher rd = request.getRequestDispatcher(responsePage);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		// read values from the form
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
		System.out.println(newTask);
		
		Tasks tasks = new Tasks();
		if (tasks.addTask(newTask)) {
			RequestDispatcher rd = request.getRequestDispatcher("dashboard");
			rd.forward(request, response);
		}
	}

}
