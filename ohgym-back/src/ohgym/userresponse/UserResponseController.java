package ohgym.userresponse;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class UserResponseController {
	@Autowired
	private UserResponseService service;
	
	@GetMapping("/userresp")
	public 
	
	@Override
	  protected void doGet(HttpServletRequest request, HttpServletResponse response) {
    	service = new UserResponseServiceImpl(new UserResponseDAOImpl());
    	String category = request.getParameter("category");
    	
    	List<String> list = service.responseList(category);;
		ObjectMapper mapper = new ObjectMapper();
    	String json = mapper.writeValueAsString(list);
    	
    	response.getWriter().write(json);
	}
}