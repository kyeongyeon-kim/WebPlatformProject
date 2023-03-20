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

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/commentfind")
public class CommentFindServlet extends HttpServlet {
	@Autowired
	private CommentService service;
	private List<CommentInfo> commentInfoList;
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
		
		// 전체 댓글 목록 조회
		commentInfoList = service.allComment();
		
		// 전체 댓글 목록 조회
		// commentInfoList = commentDAO.userComment(user_id);

		// 선생님 아이디 입력 시 해당 선생님에 대한 댓글만 조회
		// String teacher_id = "선생님";
		// commentInfoList = commentDAO.teacherComment(teacher_id);

		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(commentInfoList);

		// 객체의 toString() 메서드로 출력 결과 확인 (디버그용)
		for (int i = 0; i < commentInfoList.size(); i++) {
			System.out.println(commentInfoList.get(i).toString());
		}
		// json 형식으로 출력 결과 확인 (실제 사용용)
		System.out.println(json);
		
		PrintWriter pw = resp.getWriter();
		pw.println(json);
		pw.flush();
	}
}
