package ohgym.comment;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

@WebServlet("/commentrequest")
public class CommentRequestServlet extends HttpServlet {
	@Autowired
	CommentService service;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			resp.setContentType("text/plain");
			resp.setCharacterEncoding("UTF-8");
			
			BufferedReader reader = req.getReader();
			String str = reader.readLine();
		    str = str.substring(1, str.length() - 1);
		    String[] values = str.split(",");
		    for (int i = 0; i < values.length; i++) {
		    	values[i] = values[i].replace("\"", "");
		    }
		    
		    CommentInfo commentInfo = new CommentInfo();
		    commentInfo.setUser_id((String) values[0]);
		    commentInfo.setTeacher_id((String) values[1]);
		    commentInfo.setScore(Double.parseDouble(values[2]));
		    commentInfo.setReview((String) values[3]);
		    
		    service.commentInsert(commentInfo);
	    	System.out.println(commentInfo.toString());
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	}
}
