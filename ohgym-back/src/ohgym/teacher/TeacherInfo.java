package ohgym.teacher;


public class TeacherInfo {
	private String id;
	private String contact_time;
	private String appeal;
	public TeacherInfo() {};
	public TeacherInfo(String id, String contact_time, String appeal) {
		super();
		this.id = id;
		this.contact_time = contact_time;
		this.appeal = appeal;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContact_time() {
		return contact_time;
	}
	public void setContact_time(String contact_time) {
		this.contact_time = contact_time;
	}
	public String getAppeal() {
		return appeal;
	}
	public void setAppeal(String appeal) {
		this.appeal = appeal;
	}
	@Override
	public String toString() {
		return "TeacherInfo [id=" + id + ", contact_time=" + contact_time + ", appeal=" + appeal + "]";
	}
}
