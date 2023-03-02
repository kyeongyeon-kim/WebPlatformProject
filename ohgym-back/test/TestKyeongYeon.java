import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import ohgym.dbutil.ConnectionProvider;
import ohgym.request.Request;
import ohgym.request.RequestDAOImpl;
import ohgym.request.RequestService;
import ohgym.request.RequestServiceImpl;
import ohgym.userrequest.RequestFind;

public class TestKyeongYeon {
		@Test
		public void filterTest() {
			String sql = "SELECT * FROM request_answer AS A" + 
					" LEFT OUTER JOIN request AS B on A.request_no = B.request_no" + 
					" WHERE user_id = ?";
			List<RequestFind> list = new ArrayList<>();
			try (Connection conn = ConnectionProvider.getConnection();
					PreparedStatement stmt = conn.prepareStatement(sql);) {
				stmt.setString(1, "경연");
				
				try (ResultSet rs = stmt.executeQuery()) {
					while(rs.next()) {
						RequestFind request = new RequestFind();
						request.setRequest_no(rs.getInt("request_no"));
						request.setUser_id(rs.getString("user_id"));
						request.setExercise_type(rs.getString("exercise_type"));
						request.setRequest_date(rs.getString("request_date"));
						request.setDeadline_date(rs.getString("deadline_date"));
						request.setMessage(rs.getString("message"));
						request.setAnswer1(rs.getString("answer") + "/" + "다이어트");
						request.setAnswer2(rs.getString("answer") + "/" + "다이어트");
						request.setAnswer3(rs.getString("answer") + "/" + "다이어트");
						request.setAnswer4(rs.getString("answer") + "/" + "다이어트");
						request.setAnswer5(rs.getString("answer") + "/" + "다이어트");
						request.setAnswer6(rs.getString("answer") + "/" + "다이어트");
						request.setAnswer7(rs.getString("answer") + "/" + "다이어트");
						list.add(request);
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println(list);
		}
		
		@Test
		public void filterTest2() {
//			String str = "부산 부산진구 중앙대로 749 혜도빌딩 4층 그린컴퓨터아카데미";
//			RequestService service = new RequestServiceImpl(new RequestDAOImpl());
//			List<Request> list = service.selectRequest();
//			System.out.println(str.substring(0, 2));
//			for (Request request : list) {
//				if (str.substring(0, 2).equals("부산")) {
//					
//					System.out.println("true");
//				}
//			}
		}
}
