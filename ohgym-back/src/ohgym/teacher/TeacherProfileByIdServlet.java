
package ohgym.teacher;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;


@WebServlet("/profileId")
public class TeacherProfileByIdServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		resp.setContentType("application/json");
//
//		TeacherService service = new TeacherServiceImpl(new TeacherDAOImpl());
//		String id = "경태";
//		
//		List<TeacherProfile> teacherprofile = service.readTeacherProfile(id);
//		ObjectMapper mapper = new ObjectMapper();
//		String json = mapper.writeValueAsString(teacherprofile.get(0));
//		PrintWriter pw = resp.getWriter();
//		System.out.println(json);
//		pw.println(json);
//		pw.flush();
		System.out.println("여기");
		System.out.println(req);
	}
}
