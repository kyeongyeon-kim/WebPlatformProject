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

import ohgym.request.Request;
import ohgym.request.RequestDAOImpl;
import ohgym.request.RequestService;
import ohgym.request.RequestServiceImpl;


// TeacherController에 메서드로 정의했음 => 확인되면 삭제하기!!!
@WebServlet("/teacherPick") 
public class TeacherPickServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = "도연";
		TeacherService teacherService = new TeacherServiceImpl(new TeacherDAOImpl());
		List<TeacherProfile> list = teacherService.readUserPickTeacherProfile(id);

		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(list); 
		PrintWriter pw = resp.getWriter();
		pw.println(json);
		pw.flush();
	}

}
