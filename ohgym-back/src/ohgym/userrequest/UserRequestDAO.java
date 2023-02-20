package ohgym.userrequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import ohgym.dbutil.ConnectionProvider;

public class UserRequestDAO { 
	public void requestAdd(String user_id, String exercise_type, String str) {
        LocalDateTime RequestDate = LocalDateTime.now();
        LocalDateTime DeadlineDate = RequestDate.plusHours(72);
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String RequestDateStr = RequestDate.format(formatter);
        String DeadlineDateaStr = DeadlineDate.format(formatter);

		String sql = "INSERT INTO request (user_id, exercise_type, request_date, deadline_date, message) VALUES ('"
				+ user_id + "', '"
				+ exercise_type + "', '" 
				+ RequestDateStr + "', '"
				+ DeadlineDateaStr + "', '"
				+ str + "')";
		
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void requestAnswerAddData(String[] arr) {
		String number = null;
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement stmt = conn.prepareStatement("SELECT no FROM request ORDER BY no DESC LIMIT 1")){
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				number = rs.getString("no");
			}
			stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String page = null;
		String sql = null;
		
		for (int i = 0; i < 38; i++) {
			if (i < 9){
				page = "1";
			} else if (i < 14) {
				page = "2";
			} else if (i < 22) {
				page = "3";
			} else if (i < 28) {
				page = "4";
			} else if (i < 31) {
				page = "5";
			} else if (i < 37) {
				page = "6";
			} else {
				page = "7";
			}
			if (!arr[i].equals("null")) {
				sql = "INSERT INTO request_answer (request_no, question, answer) VALUES ("+ number + ", " + page + ", '"+ arr[i] + "');";
				requestAnswerAddData(sql);
			}
		}
	}
	
	public void requestAnswerAddData(String sql) {
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
