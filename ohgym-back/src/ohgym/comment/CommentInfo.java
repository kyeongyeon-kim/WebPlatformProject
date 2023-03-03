package ohgym.comment;

public class CommentInfo {
	private int no;
	private String user_id;
	private String teacher_id;
	private double score;
	private String review;
	public CommentInfo() {}
	public CommentInfo(int no, String user_id, String teacher_id, double score, String review) {
		super();
		this.no = no;
		this.user_id = user_id;
		this.teacher_id = teacher_id;
		this.score = score;
		this.review = review;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	@Override
	public String toString() {
		return "UserCommentInfo [no=" + no + ", user_id=" + user_id + ", teacher_id=" + teacher_id + ", score=" + score
				+ ", review=" + review + "]";
	}
}
