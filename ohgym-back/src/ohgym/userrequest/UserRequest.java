package ohgym.userrequest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/userreq")
public class UserRequest extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			resp.setContentType("text/plain");
			resp.setCharacterEncoding("UTF-8");
			
			String requestData = req.getReader().lines().reduce("", (accumulator, actual) -> accumulator + actual);
			String[] arr = requestData.replaceAll("[\\[\\]{}\"]", "").split(",");

			// 세션에서 user_id
			String user_id = "1";
			
	    	UserRequestDAO userRequestDAO = new UserRequestDAO();
	    	userRequestDAO.requestAdd(user_id, arr[39], arr[38]);
	    	userRequestDAO.requestAnswerAddData(arr);
	    	
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	}
}
