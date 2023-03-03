package ohgym.request;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import ohgym.teacher.TeacherDAOImpl;
import ohgym.teacher.TeacherService;
import ohgym.teacher.TeacherServiceImpl;
import ohgym.userrequest.RequestFind;

@WebServlet("/requestNo")
public class RequestByNoServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestService service = new RequestServiceImpl(new RequestDAOImpl());
		TeacherService teacherService = new TeacherServiceImpl(new TeacherDAOImpl());
		
		Request request = service.selectRequestByNo(6);
		RequestFind requestFind = new RequestFind("다이어트,체력증진","개인레슨,단체레슨","무관","19시 이전","남자","20대","부산","잘부탁해용");
		Object[] arr = new Object[]{request, requestFind};
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(arr);
	 
		PrintWriter pw = resp.getWriter();
		pw.println(json);
		pw.flush();
	}
}
