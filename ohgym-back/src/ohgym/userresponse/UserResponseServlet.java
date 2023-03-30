package ohgym.userresponse;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/userresp")
public class UserResponseServlet extends HttpServlet {
	@Override
	  protected void doGet(HttpServletRequest request, HttpServletResponse response) {
	    try {  
	    	UserResponseService service = new UserResponseServiceImpl(new UserResponseDAOImpl());
	    	String category = request.getParameter("category");
	    	
	    	List<String> list = service.responseList(category);;
			ObjectMapper mapper = new ObjectMapper();
	    	String json = mapper.writeValueAsString(list);
	    	
	    	response.getWriter().write(json);
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	}
}