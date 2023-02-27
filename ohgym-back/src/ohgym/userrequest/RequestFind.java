package ohgym.userrequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ohgym.dbutil.ConnectionProvider;

public class RequestFind {
	private int request_no;
	private String user_id;
	private String exercise_type;
	private String request_date;
	private String deadline_date;
	private String message;
	private int question;
	private String answer;
	
	public RequestFind (int requestAnswerNo) {
		request(requestAnswerNo);
	}

	public void request(int requestAnswerNo) {
		String sql = "SELECT * FROM request JOIN request_answer ON request.request_no = request_answer.request_no WHERE request_answer.no = " + requestAnswerNo;

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

	public int getQuestion() {
		return question;
	}

	public void setQuestion(int question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "RequestFind [request_no=" + request_no + ", user_id=" + user_id + ", exercise_type=" + exercise_type
				+ ", request_date=" + request_date + ", deadline_date=" + deadline_date + ", message=" + message
				+ ", question=" + question + ", answer=" + answer + "]";
	}
	
}