
package ohgym.teacher;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import ohgym.dbutil.ConnectionProvider;


@WebServlet("/profile")
public class TeacherProfileServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		TeacherService service = new TeacherServiceImpl(new TeacherDAOImpl());
		
		HttpSession session = req.getSession();
		String userId = (String) session.getAttribute("userId");
		userId = "경태";
		
		TeacherProfile teacherProfile = service.readTeacherProfile(userId);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(teacherProfile); 
		System.out.println(json);
		PrintWriter pw = resp.getWriter();
		resp.getWriter().println(json);
		pw.flush();
	}
}
