package ohgym.comment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/commentfind")
public class CommentFindServlet extends HttpServlet {
	List<CommentInfo> commentInfoList;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BufferedReader reader = req.getReader();
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			sb.append(line);
		}
		String user_id = sb.toString();
		
		commentInfoList = new ArrayList<>();
		CommentDAO commentDAO = new CommentDAO();
		
		// 전체 리뷰
		commentInfoList = commentDAO.allComment();
		
		// user_id 입력으로 리뷰
//		commentInfoList = commentDAO.userComment(user_id);
		
		// teacher_id 입력으로 리뷰
//		String teacher_id = "경태";
//		commentInfoList = commentDAO.teacherComment(teacher_id);
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(commentInfoList);
		
		// 콘솔에서 toString형태로 체크(여러 줄)
		for (int i = 0; i < commentInfoList.size(); i++) {
			System.out.println(commentInfoList.get(i).toString());
		}
		// 콘솔에서 json 형태로 체크(한 줄)
		System.out.println(json);
		
		PrintWriter pw = resp.getWriter();
		pw.println(json);
		pw.flush();
	}
}
