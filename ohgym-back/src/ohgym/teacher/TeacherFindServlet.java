package ohgym.teacher;

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


@WebServlet("/find")
public class TeacherFindServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TeacherService service = new TeacherServiceImpl(new TeacherDAOImpl());
		List<TeacherProfile> list = service.readAllTeacherProfile();
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("/jsp/find.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BufferedReader reader = req.getReader();
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			sb.append(line);
		}

		TeacherService service = new TeacherServiceImpl(new TeacherDAOImpl());
		List<TeacherProfile> profileById = service.readTeacherProfile(line);
			
		req.setAttribute("list", profileById);
		req.getRequestDispatcher("/jsp/find.jsp").forward(req, resp);
	}
}
