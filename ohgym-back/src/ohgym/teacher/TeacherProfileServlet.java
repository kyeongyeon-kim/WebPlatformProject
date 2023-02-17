
package ohgym.teacher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;


@WebServlet("/profile")
public class TeacherProfileServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		TeacherService service = new TeacherServiceImpl(new TeacherDAOImpl());
		
		HttpSession session = req.getSession();
		String userid = (String) session.getAttribute("userid");
		userid = "경태";
		
		TeacherProfile teacherprofile = service.readTeacherProfile(userid);
		System.out.println(teacherprofile);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(teacherprofile); 
		System.out.println(json);
		PrintWriter pw = resp.getWriter();
		pw.println(json);
	}
}
