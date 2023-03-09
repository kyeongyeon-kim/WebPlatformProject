package ohgym.login;

public class LoginUser {
    private String userId;
    private String userPassword;
    private int userCheck;
    
    public LoginUser() {}
    public LoginUser(String userId, String userPassword, int userCheck) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userCheck = userCheck;
    }
    public String getUserId() {
        return userId;
    }
    public String getUserPassword() {
        return userPassword;
    }
    public int getUserCheck() {
    	return userCheck;
    }
	@Override
	public String toString() {
		return "LoginUser [userId=" + userId + ", userPassword=" + userPassword + ", userCheck=" + userCheck + "]";
	}
    
}