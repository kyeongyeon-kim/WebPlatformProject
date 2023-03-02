package ohgym.user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import ohgym.teacher.TeacherDAOImpl;
import ohgym.teacher.TeacherProfile;
import ohgym.teacher.TeacherService;
import ohgym.teacher.TeacherServiceImpl;

@WebServlet("/change")
public class UserChangeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id ="도연";
				
		
		UserService service = new UserServiceImpl(new UserDAOImpl());
		User user = service.readUserInfo(id);
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(user);
		
		PrintWriter pw = resp.getWriter();
		resp.getWriter().print(json);
		pw.flush();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BufferedReader reader = req.getReader();
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			sb.append(line);
		}
		ObjectMapper mapper = new ObjectMapper();
		String strUser = sb.toString();
		
		User user = mapper.readValue(strUser, User.class);
		UserService service = new UserServiceImpl(new UserDAOImpl());
		int check = service.updateUser(user);
		
		PrintWriter pw = resp.getWriter();
		resp.getWriter().print(check);
		pw.flush();
			
	}
}
