package ohgym.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@GetMapping("/login")
	public void login() {}
	
	@PostMapping("/login")
	public String login(HttpServletRequest request) {
		String userId = request.getParameter("userId");
		String userPassword = request.getParameter("userPassword");
		boolean authenticated = loginService.authenticate(userId, userPassword);		
		if (authenticated) {
			LoginUser user = new LoginUser(userId, userPassword, 1);
			HttpSession session = request.getSession();
			session.setAttribute("id", user.getUserId());
			session.setAttribute("usercheck", user.getUserCheck());
			session.setMaxInactiveInterval(30*60);
			
		    return "redirect:./";
		} else {
			request.setAttribute("errorMessage", "아이디와 비밀번호를 확인해주세요.");
			return "login";
		}
	}
}
