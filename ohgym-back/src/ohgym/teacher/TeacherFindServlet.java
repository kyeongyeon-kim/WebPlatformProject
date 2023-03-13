package ohgym.teacher;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/find")
public class TeacherFindServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TeacherService service = new TeacherServiceImpl(new TeacherDAOImpl());
		List<TeacherProfile> list = service.readAllTeacherProfile();
		String area = req.getParameter("area");
		String search = req.getParameter("search");
		if (area != null) {
			req.setAttribute("area", area);
		}
		String inputText = req.getParameter("search");
		if (inputText != null) {
			req.setAttribute("inputText", inputText);
		}
		req.setAttribute("list", list);
		req.getRequestDispatcher("/views/find.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TeacherService service = new TeacherServiceImpl(new TeacherDAOImpl());
		List<TeacherProfile> list = service.readAllTeacherProfile();
		String area = req.getParameter("area");
		String search = req.getParameter("search");
		if (area != null) {
			req.setAttribute("area", area);
		}
		String inputText = req.getParameter("search");
		if (inputText != null) {
			req.setAttribute("inputText", inputText);
		}
		req.setAttribute("list", list);
		req.getRequestDispatcher("/views/find.jsp").forward(req, resp);
	}
}
