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

import com.fasterxml.jackson.databind.ObjectMapper;

import ohgym.dbutil.ConnectionProvider;


@WebServlet("/find")
public class TeacherServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		resp.setHeader("Access-Control-Allow-Headers", "*");
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		TeacherService service = new TeacherServiceImpl(new TeacherDAOImpl());
		List<TeacherInfo> list = service.readTeacherInfo();
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(list); 
		
		PrintWriter pw = resp.getWriter();
		resp.getWriter().println(json);
		pw.flush();
	}
}
