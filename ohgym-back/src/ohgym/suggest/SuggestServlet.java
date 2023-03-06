package ohgym.detailRequest;

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
import ohgym.teacher.TeacherDAOImpl;
import ohgym.teacher.TeacherService;
import ohgym.teacher.TeacherServiceImpl;


@WebServlet("/suggestGo")
public class SuggestServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SuggestService service = new SuggestServiceImpl(new SuggestDAOImpl());		
		List<Suggest> list = service.selectSuggest();
		System.out.println(list);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(list); 
		PrintWriter pw = resp.getWriter();
		pw.println(json);
		pw.flush();
	}	
}


