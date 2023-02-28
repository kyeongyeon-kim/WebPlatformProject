package ohgym.user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/out")
public class UserOutServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Access-Control-Allow-Methods", "POST, OPTIONS");
		resp.setHeader("Access-Control-Allow-Headers", "*");
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		BufferedReader reader = req.getReader();
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			sb.append(line);
		}
		ObjectMapper mapper = new ObjectMapper();
		String strUser = sb.toString();
		User user = mapper.readValue(strUser, User.class);
		String id = user.getId();
		UserService service = new UserServiceImpl(new UserDAOImpl());
		int check = service.deleteUser(id);
		
		PrintWriter pw = resp.getWriter();
		resp.getWriter().print(check);
		pw.flush();
	}


	
}
