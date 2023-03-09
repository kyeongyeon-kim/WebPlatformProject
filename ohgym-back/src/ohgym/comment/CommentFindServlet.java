package ohgym.comment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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
		CommentService service = new CommentServiceImpl(new CommentDAOImpl());
		
		// ��ü ����
		commentInfoList = service.allComment();
		
		// user_id �Է����� ����
//		commentInfoList = commentDAO.userComment(user_id);
		
		// teacher_id �Է����� ����
//		String teacher_id = "����";
//		commentInfoList = commentDAO.teacherComment(teacher_id);
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(commentInfoList);
		
		// �ֿܼ��� toString���·� üũ(���� ��)
		for (int i = 0; i < commentInfoList.size(); i++) {
			System.out.println(commentInfoList.get(i).toString());
		}
		// �ֿܼ��� json ���·� üũ(�� ��)
		System.out.println(json);
		
		PrintWriter pw = resp.getWriter();
		pw.println(json);
		pw.flush();
	}
}
