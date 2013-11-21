package todo.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		HttpSession session = request.getSession();
		if(session.getAttribute("useremail") == null || session.getAttribute("useremail").equals("")) {
			// if not logged in, redirect to login page
			RequestDispatcher rd = request.getRequestDispatcher("login");
			rd.forward(request, response);
		} else {
			// if logged in, show dashboard
			RequestDispatcher rd = request.getRequestDispatcher("/dashboard.jsp");
			rd.forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("useremail") == null || session.getAttribute("useremail").equals("")) {
			// if not logged in, redirect to login page
			RequestDispatcher rd = request.getRequestDispatcher("login");
			rd.forward(request, response);
		} else {
			// if logged in, show dashboard
			RequestDispatcher rd = request.getRequestDispatcher("/dashboard.jsp");
			rd.forward(request, response);
		}
	}

}
