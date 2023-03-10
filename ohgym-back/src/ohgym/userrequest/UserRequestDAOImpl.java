package ohgym.userrequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserRequestDAOImpl implements UserRequestDAO {
	@Override
	public void requestAdd(String user_id, String exercise_type, String str, Connection conn) throws SQLException {
		LocalDateTime RequestDate = LocalDateTime.now();
        LocalDateTime DeadlineDate = RequestDate.plusHours(72);
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String RequestDateStr = RequestDate.format(formatter);
        String DeadlineDateaStr = DeadlineDate.format(formatter);
        
        if (str.equals("null")) {
        	str = "', null)";
        } else {
        	str = "', '" + str + "')";
        }

		String sql = "INSERT INTO request (user_id, exercise_type, request_date, deadline_date, message) VALUES ('"
				+ user_id + "', '"
				+ exercise_type + "', '" 
				+ RequestDateStr + "', '"
				+ DeadlineDateaStr
				+ str;
		System.out.println(sql);
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.executeUpdate();
		}
	}
	@Override
	public void requestAnswerAdd(String[] arr, Connection conn) throws SQLException {
		String page = null;
		String sql = null;
		
		for (int i = 0; i < 38; i++) {
			page = requestPage(i);
			if (!arr[i].equals("null")) {
				sql = "INSERT INTO request_answer (request_no, question, answer) "
								+ "SELECT request_no, " + page + ", '" + arr[i] + "' "
								+ "FROM request ORDER BY request_no DESC LIMIT 1";
				
				try (PreparedStatement stmt = conn.prepareStatement(sql)) {
					stmt.executeUpdate();
				}
			}
		}
	}
	public String requestPage(int i) {
		if (i < 9){
			return "1";
		} else if (i < 14) {
			return "2";
		} else if (i < 22) {
			return "3";
		} else if (i < 28) {
			return "4";
		} else if (i < 31) {
			return "5";
		} else if (i < 37) {
			return "6";
		} else {
			return "7";
		}
	}
}
