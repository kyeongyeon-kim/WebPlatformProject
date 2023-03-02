package ohgym.signup;

public class SignupUser {
	private String userId;
    private String userPassword;
    private String userName;
    private String userPhone;
    private String userBirthday;
    private String userGender;
    private int usercheck;
    public SignupUser() {}
	public SignupUser(String userId, String userPassword, String userName, String userPhone, 
			String userBirthday, String userGender, int usercheck) {
		super();
		this.userId = userId;
		this.userPassword = userPassword;
		this.userPhone = userPhone;
		this.userName = userName;
		this.userBirthday = userBirthday;
		this.userGender = userGender;
		this.usercheck = usercheck;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserBirthday() {
		return userBirthday;
	}
	public void setUserBirthday(String userBirthday) {
		this.userBirthday = userBirthday;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public int getUsercheck() {
		return usercheck;
	}
	public void setUsercheck(int usercheck) {
		this.usercheck = usercheck;
	}
	
}
