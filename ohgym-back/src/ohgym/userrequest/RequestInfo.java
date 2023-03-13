package ohgym.userrequest;

public class RequestInfo {
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
	
	public RequestInfo() {}
	
	public RequestInfo(int request_no, String user_id, String exercise_type, String request_date, String deadline_date,
			String message, String answer1, String answer2, String answer3, String answer4, String answer5,
			String answer6, String answer7) {
		super();
		this.request_no = request_no;
		this.user_id = user_id;
		this.exercise_type = exercise_type;
		this.request_date = request_date;
		this.deadline_date = deadline_date;
		this.message = message;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.answer3 = answer3;
		this.answer4 = answer4;
		this.answer5 = answer5;
		this.answer6 = answer6;
		this.answer7 = answer7;
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
		return "RequestInfo [request_no=" + request_no + ", user_id=" + user_id + ", exercise_type=" + exercise_type
				+ ", request_date=" + request_date + ", deadline_date=" + deadline_date + ", message=" + message
				+ ", answer1=" + answer1 + ", answer2=" + answer2 + ", answer3=" + answer3 + ", answer4=" + answer4
				+ ", answer5=" + answer5 + ", answer6=" + answer6 + ", answer7=" + answer7 + "]";
	}
	
	
}