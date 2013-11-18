package election.web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import election.web.exceptions.ElectionException;
import election.web.model.Candidates;
import election.web.model.ElectoralRoll;

/**
 * Servlet implementation class VoteServlet
 */
@WebServlet("/vote")
public class VoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VoteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ElectoralRoll electors = ElectoralRoll.getInstance();
		String voterName = (String) request.getSession().getAttribute(
				"voterName");
		if ( voterName == null || electors.getVoter(voterName).isVoted() ) {
			request.setAttribute("message", "You cannot vote twice.");
			request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
			return;
			}
		electors.getVoter(voterName).setVoted(true);
		Candidates candidates = Candidates.getInstance();
		for (String cName : candidates.getCandidateNames()) {
			if (request.getParameter(cName) != null) {
				try {
					candidates.voteFor(cName);
					candidates.printVoteCount(System.out);
					request.getSession().invalidate();
					request.getRequestDispatcher("/done.html").forward(request,
							response);
					return;
				} catch (ElectionException e) {
					request.setAttribute("message", e.getMessage());

					request.getRequestDispatcher("/errorPage.jsp").forward(
							request, response);
					return;
				}
			}
		}
		// reached when form data returns none of candidate names
		request.setAttribute("message", "spoiled ballet");
		request.getRequestDispatcher("/errorPage.jsp").forward(request,
				response);
	}
}
