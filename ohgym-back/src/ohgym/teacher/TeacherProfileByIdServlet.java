
package ohgym.teacher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
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
//		System.out.println(req.getMethod());
//		System.out.println(req.getQueryString());

//		String reqId = req.getParameter("id");
//		String decoded = URLDecoder.decode(reqId, "UTF-8");
//		System.out.println(decoded);
//		req.setAttribute("id", decoded);
//		resp.sendRedirect("http://localhost:8080/ohgym/jsp/teacherProfile.jsp?id=" + reqId);
		resp.sendRedirect("http://localhost:8080/ohgym/jsp/teacherProfile.jsp");
//		req.getRequestDispatcher("teacherProfile.jsp").forward(req, resp);
		
	}
}
