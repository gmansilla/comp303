package todo.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		// TODO Auto-generated method stub
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
				
				if(! user.loginUser(loginUser)) {
					throw new UserNotFoundException("Unable to authenticate the user");
				} else {
					// login success
					responsePage = "/dashboard.jsp";
					session.setAttribute("useremail", useremail);
				}
			}
			
		} catch (UserNotFoundException unf) {

		} finally {
			RequestDispatcher rd = request.getRequestDispatcher(responsePage);
			rd.forward(request, response);
		}
		
	}

}
