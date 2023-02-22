package ohgym.userrequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ohgym.dbutil.ConnectionProvider;

public class RequestFind {
	int request_no;
	String user_id;
	String exercise_type;
	String request_date;
	String deadline_date;
	String message;
	int question;
	String answer;
	
	public RequestFind (int requestAnswerNo) {
		request(requestAnswerNo);
	}

	public void request(int requestAnswerNo) {
		String sql = "SELECT * FROM request JOIN request_answer ON request.no = request_answer.request_no WHERE request_answer.no = " + requestAnswerNo;
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				request_no = rs.getInt("request_no");
				user_id = rs.getString("user_id");
				exercise_type = rs.getString("exercise_type");
				request_date = rs.getString("request_date");
				deadline_date = rs.getString("deadline_date");
				message = rs.getString("message");
				question = rs.getInt("question");
				answer = rs.getString("answer");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}