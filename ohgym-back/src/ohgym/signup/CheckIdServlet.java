
package ohgym.signup;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/checkid")
public class CheckIdServlet extends HttpServlet {
	private SignupService service;

	@Override
	public void init() throws ServletException {
		super.init();
		service = new SignupService(new SignupDAOImpl());
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)

	}
}
