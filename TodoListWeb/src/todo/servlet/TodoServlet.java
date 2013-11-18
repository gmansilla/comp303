package todo.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		}
		RequestDispatcher rd = request.getRequestDispatcher(responsePage);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String responsePage = "/success.jsp";
		try {
			//TODO try to save data
		} catch (Exception e) {
			responsePage = "/error.jsp";
		} finally {
			RequestDispatcher rd = request.getRequestDispatcher(responsePage);
			rd.forward(request, response);
		}
	}

}
