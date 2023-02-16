package ohgym.teacher;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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

		
		TeacherDAO dao = new TeacherDAOImpl();
		List<TeacherInfo> list = null;
		try {
			list = dao.selectInfo(ConnectionProvider.getConnection());
		} catch (SQLException e) {
			System.out.println("예외");
			e.printStackTrace();
		}
		resp.getWriter().println(list);
	}
}
