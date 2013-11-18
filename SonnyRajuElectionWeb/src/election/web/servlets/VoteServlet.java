package election.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		HttpSession session = request.getSession();
		Candidates candidates = new Candidates();
		
		String voterName = (String) session.getAttribute("voterName");
		ElectoralRoll electors = ElectoralRoll.getInstance();
		try {
			if (voterName == null) {
				throw new ElectionException("You must sign in before voting");
			} else if (electors.getVoter(voterName).isVoted()) {
				throw new ElectionException("You cannot vote twice.");
			}
			electors.getVoter(voterName).setVoted(true);
			request.getSession().invalidate();
			for (String cName : candidates.getCandidateNames()) {
				if (request.getParameter(cName) != null) {
					candidates.voteFor(cName);
					candidates.printVoteCount(System.out);
					request.getRequestDispatcher("/done.html").forward(request,
							response);
					return;
				}
			}
			// reached when form data returns none of candidate names
			throw new ElectionException( "spoiled ballet: candidate not recogized" );
		} catch (ElectionException e) {
			session.invalidate();
			request.setAttribute("message", e.getMessage());
			request.getRequestDispatcher("/errorPage.jsp").forward(request,
					response);
			return;
		}
	}
}
