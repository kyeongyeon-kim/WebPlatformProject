package ohgym.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Autowired
	private LoginService loginService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userPassword = request.getParameter("userPassword");
		System.out.println(userId);
		boolean authenticated = loginService.authenticate(userId, userPassword);		
		if (authenticated) {
			LoginUser user = new LoginUser(userId, userPassword, 1);
			HttpSession session = request.getSession();
			session.setAttribute("id", user.getUserId());
			session.setAttribute("usercheck", user.getUserCheck());
			session.setMaxInactiveInterval(30*60);
			
			String redirectUrl = "./";
		    response.sendRedirect(redirectUrl);	   
		} else {
			request.setAttribute("errorMessage", "아이디와 비밀번호를 확인해주세요.");
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);

		}
	}
}