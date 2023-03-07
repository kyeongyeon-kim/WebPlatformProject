
package ohgym.teacher;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/profileId")
public class TeacherProfileByIdServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = (String) req.getParameter("id");
				
		TeacherService service = new TeacherServiceImpl(new TeacherDAOImpl());
		List<TeacherProfile> profileById = service.readTeacherProfile(id);
		
		req.setAttribute("profileById", profileById);
		req.getRequestDispatcher("/views/teacherProfile.jsp").forward(req, resp);
	}
}
