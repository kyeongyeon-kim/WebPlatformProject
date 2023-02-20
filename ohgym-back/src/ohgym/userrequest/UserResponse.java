package ohgym.userrequest;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/userresp")
public class UserResponse extends HttpServlet {
	@Override
	  protected void doGet(HttpServletRequest request, HttpServletResponse response) {
	    try {  
	    	UserResponseDAO userRespDao = new UserResponseDAO();
	    	String category = request.getParameter("category");
	    	String categoryName = userRespDao.categoryName(category);
	    	String requestNum = userRespDao.requestNum(category);
	    	String scoreNum = userRespDao.scoreNum(category);
	    	String reviewNum = userRespDao.reviewNum(category);
	    	String activeNum = userRespDao.activeNum(category);
	    	List<String> list = new ArrayList<String>();
	    	list.add(requestNum);
	    	list.add(scoreNum);
	    	list.add(reviewNum);
	    	list.add(activeNum);
	    	list.add(categoryName);
			ObjectMapper mapper = new ObjectMapper();
	    	String json = mapper.writeValueAsString(list);
	    	
	    	response.getWriter().write(json);
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	}
}
