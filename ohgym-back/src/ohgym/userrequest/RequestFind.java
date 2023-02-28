package ohgym.userrequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ohgym.dbutil.ConnectionProvider;

public class RequestFind {
	private int request_no;
	private String user_id;
	private String exercise_type;
	private String request_date;
	private String deadline_date;
	private String message;
	private String answer1;
	private String answer2;
	private String answer3;
	private String answer4;
	private String answer5;
	private String answer6;
	private String answer7;
	
	public RequestFind (int request_no) {
		requestFind(request_no);

		answer1 = null;
		answer2 = null;
		answer3 = null;
		answer4 = null;
		answer5 = null;
		answer6 = null;
		answer7 = null;
		
		List<Integer> requestAnswerNoList = new ArrayList<>();
		String sql = "SELECT request_answer.no FROM request_answer WHERE request_no = " + request_no;
		
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
			requestAnswerFind(requestAnswerNoList.get(i));
		}
		
	}
	
	public void requestAnswerFind(int requestAnswerNo) {
		String sql = "SELECT * FROM request_answer WHERE request_answer.no = " + requestAnswerNo;
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				switch (rs.getInt("question")) {
					case 1:
						if (answer1 == null) {
							answer1 = rs.getString("answer");
						} else {
							answer1 += "," + rs.getString("answer");
						}
						break;
					case 2:
						if (answer2 == null) {
							answer2 = rs.getString("answer");
						} else {
							answer2 += "," + rs.getString("answer");
						}
						break;
					case 3:
						if (answer3 == null) {
							answer3 = rs.getString("answer");
						} else {
							answer3 += "," + rs.getString("answer");
						}
						break;
					case 4:
						if (answer4 == null) {
							answer4 = rs.getString("answer");
						} else {
							answer4 += "," + rs.getString("answer");
						}
						break;
					case 5:
						if (answer5 == null) {
							answer5 = rs.getString("answer");
						} else {
							answer5 += "," + rs.getString("answer");
						}
						break;
					case 6:
						if (answer6 == null) {
							answer6 = rs.getString("answer");
						} else {
							answer6 += "," + rs.getString("answer");
						}
						break;
					case 7:
						if (answer7 == null) {
							answer7 = rs.getString("answer");
						} else {
							answer7 += "," + rs.getString("answer");
						}
						break;
					default:
						break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void requestFind(int request_no) {
		String sql = "SELECT * FROM request WHERE request_no = " + request_no;
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)){
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				this.user_id = rs.getString("user_id");
				this.request_no = rs.getInt("request.request_no");
				exercise_type = rs.getString("exercise_type");
				request_date = rs.getString("request_date");
				deadline_date = rs.getString("deadline_date");
				message = rs.getString("message");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int getRequest_no() {
		return request_no;
	}

	public void setRequest_no(int request_no) {
		this.request_no = request_no;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getExercise_type() {
		return exercise_type;
	}

	public void setExercise_type(String exercise_type) {
		this.exercise_type = exercise_type;
	}

	public String getRequest_date() {
		return request_date;
	}

	public void setRequest_date(String request_date) {
		this.request_date = request_date;
	}

	public String getDeadline_date() {
		return deadline_date;
	}

	public void setDeadline_date(String deadline_date) {
		this.deadline_date = deadline_date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getAnswer1() {
		return answer1;
	}

	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}

	public String getAnswer2() {
		return answer2;
	}

	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}

	public String getAnswer3() {
		return answer3;
	}

	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}

	public String getAnswer4() {
		return answer4;
	}

	public void setAnswer4(String answer4) {
		this.answer4 = answer4;
	}

	public String getAnswer5() {
		return answer5;
	}

	public void setAnswer5(String answer5) {
		this.answer5 = answer5;
	}

	public String getAnswer6() {
		return answer6;
	}

	public void setAnswer6(String answer6) {
		this.answer6 = answer6;
	}

	public String getAnswer7() {
		return answer7;
	}

	public void setAnswer7(String answer7) {
		this.answer7 = answer7;
	}

	@Override
	public String toString() {
		return "RequestFind [request_no=" + request_no + ", user_id=" + user_id + ", exercise_type=" + exercise_type
				+ ", request_date=" + request_date + ", deadline_date=" + deadline_date + ", message=" + message
				+ ", answer1=" + answer1 + ", answer2=" + answer2 + ", answer3=" + answer3 + ", answer4=" + answer4
				+ ", answer5=" + answer5 + ", answer6=" + answer6 + ", answer7=" + answer7 + "]";
	}
	
}