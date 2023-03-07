package ohgym.suggest;

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

@WebServlet("/suggestTeacherInfo")
public class SuggestTeacherServlet extends HttpServlet{

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
