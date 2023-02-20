package ohgym.Request;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/requestList")
public class RequestListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestService service = new RequestServiceImpl(new RequestDAOImpl());
		List<Request> list = service.selectRequest();
		System.out.println(list);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(list); 
      
		PrintWriter pw = resp.getWriter();
		pw.println(json);
		pw.flush();
	}
}
