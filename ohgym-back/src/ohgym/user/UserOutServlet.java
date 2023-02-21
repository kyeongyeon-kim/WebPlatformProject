package ohgym.user;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/out")
public class UserOutServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		resp.setHeader("Access-Control-Allow-Headers", "*");
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
	
		String id="도연";
		
		UserService service = new UserServiceImpl(new UserDAOImpl());
		int check = service.deleteUser(id);
		
		System.out.println(check);
	}
	
}
