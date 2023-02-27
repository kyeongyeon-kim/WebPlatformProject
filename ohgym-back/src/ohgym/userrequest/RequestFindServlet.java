package ohgym.userrequest;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import ohgym.dbutil.ConnectionProvider;

@WebServlet("/requestfind")
public class RequestFindServlet extends HttpServlet {
	List<RequestFind> requestFindList;
	List<Integer> requestAnswerNoList;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		requestFindList = new ArrayList<>();
		requestAnswerNoList = new ArrayList<>();
		
//		user_id받기
		String user_id = "1";
		
		String sql = "SELECT request_answer.no FROM request_answer WHERE request_no IN"
				+ " (SELECT request_no FROM request WHERE user_id = " + user_id + ")";
		
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				requestAnswerNoList.add(Integer.valueOf(rs.getInt("request_answer.no")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		


		for (int i = 0; i < requestAnswerNoList.size(); i++) {
			requestFindList.add(new RequestFind((int) requestAnswerNoList.get(i)));
			System.out.println(requestFindList.get(i).toString());
		}
		
//		ObjectMapper mapper = new ObjectMapper();
//		
//		resp.setContentType("application/json");
//        resp.setCharacterEncoding("UTF-8");
//        resp.getWriter().write(mapper.writeValueAsString(requestFindList));
		
		
		
//		String json = null;
//		
//		try {
//			json = mapper.writeValueAsString(requestFindList);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		System.out.println(json);
		
//		requestFindList 보내기
//		PrintWriter pw = resp.getWriter();
//		pw.println(json);
//		pw.flush();
		
	}
	
}