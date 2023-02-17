package ohgym.user;

public class User {
	private String id;
	private String name;
	private String pw;
	private String phone;
	private String birthday;
	private String gender;
	private int usercheck;
	
	public User() {}
	public User(String id, String name, String pw, String phone, String birthday, String gender, int usercheck) {
		this.id = id;
		this.name = name;
		this.pw = pw;
		this.phone = phone;
		this.birthday = birthday;
		this.gender = gender;
		this.usercheck = usercheck;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getUsercheck() {
		return usercheck;
	}
	public void setUsercheck(int usercheck) {
		this.usercheck = usercheck;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", pw=" + pw + ", phone=" + phone + ", birthday=" + birthday
				+ ", gender=" + gender + ", usercheck=" + usercheck + "]";
	}
}
