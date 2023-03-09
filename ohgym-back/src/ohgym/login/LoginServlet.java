package ohgym.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private final LoginService loginService = new LoginService(new LoginDAOImpl());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POST");
		String userId = request.getParameter("userId");
		String userPassword = request.getParameter("userPassword");
		if (!userPassword.matches("^[ㄱ-힣a-zA-Z0-9_-]{1,10}$")) {
			response.setContentType("text/html");
//		    String errorMessage = "<p>입력한 사용자 비밀번호가 유효하지 않습니다. 영문, 한글, 숫자, 밑줄(_) 또는 대시(-) 문자를 사용하여 1자 이상 16자 이하로 입력해주세요.</p>";
//		    response.getWriter().println("<script>document.getElementById('error-message').innerHTML = '" 
//		    + errorMessage + "';</script>");
		    return;
		}

		if (!userId.matches("^[a-zA-Zㄱ-힣0-9_-]{1,10}$")) {
			//response.getWriter().println("유효성 실패한것임.");
			
			return;
		}

		boolean authenticated = loginService.authenticate(userId, userPassword);

		
		if (authenticated) {
			LoginUser user = new LoginUser(userId, userPassword);
			HttpSession session = request.getSession();
			System.out.println(user.getUserId());
			session.setAttribute("user", user.getUserId());
			session.setMaxInactiveInterval(30*60);
			System.out.println(session.getAttribute("user"));
			
			String redirectUrl = "./requestList";
			//String redirectUrl = request.getContextPath() + "/mainpage";
		    response.sendRedirect(redirectUrl);
		    
			// response.getWriter().println("11");
			// response.sendRedirect("");
		   
		} else {
			response.setContentType("application/json");
		    response.getWriter().write("로그인 실패");

			// response.getWriter().println("22");

			// response.sendRedirect("");
		}
	}
}