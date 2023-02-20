package ohgym.Request;

public class Request {
	private String no;
	private String id;
	private String exerciseType;
	private String requestDate;
	private String deadlineDate;
	private String message;
	
	public Request() {};
	
	public Request(String no, String id, String exerciseType, String requestDate, String deadlineDate, String message) {
		super();
		this.no = no;
		this.id = id;
		this.exerciseType = exerciseType;
		this.requestDate = requestDate;
		this.deadlineDate = deadlineDate;
		this.message = message;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getExerciseType() {
		return exerciseType;
	}
	public void setExerciseType(String exerciseType) {
		this.exerciseType = exerciseType;
	}
	public String getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}
	public String getDeadlineDate() {
		return deadlineDate;
	}
	public void setDeadlineDate(String deadlineDate) {
		this.deadlineDate = deadlineDate;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "Request [no=" + no + ", id=" + id + ", exerciseType=" + exerciseType + ", requestDate=" + requestDate
				+ ", deadlineDate=" + deadlineDate + ", message=" + message + "]";
	}
	
	
}
