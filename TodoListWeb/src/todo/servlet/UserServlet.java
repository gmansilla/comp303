package todo.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import todo.exception.UserNotFoundException;
import todo.model.Users;
import todolist.entities.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/login")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
		rd.forward(request, response);
	}	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		Users user = new Users();
		String responsePage = "/error.jsp";
		
		String useremail = request.getParameter("useremail");
		String password = request.getParameter("password");

		try {
			if (useremail == null || useremail.isEmpty()) {
				throw new UserNotFoundException("User Email is required");
			} else if (password == null || password.isEmpty()) {
				throw new UserNotFoundException("Password is required");
			} else {
				User loginUser = new User();
				loginUser.setEmail(useremail);
				loginUser.setPassword(password);
				User loggedinUser = user.loginUser(loginUser);
				if(loggedinUser == null) {
					throw new UserNotFoundException("Unable to authenticate the user");
				} else {
					// login success
					responsePage = "dashboard";
					session.setAttribute("userId", loggedinUser.getId());
					session.setAttribute("username", loggedinUser.getUsername());
					session.setAttribute("useremail", loggedinUser.getEmail());
				}
			}
			
		} catch (UserNotFoundException unf) {

		} finally {
			System.out.println("Redirect to " + responsePage);
			RequestDispatcher rd = request.getRequestDispatcher(responsePage);
			rd.forward(request, response);
		}
		
	}

}
