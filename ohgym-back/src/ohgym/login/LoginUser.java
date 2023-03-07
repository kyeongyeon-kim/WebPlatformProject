package ohgym.login;

public class LoginUser {
    private String userId;
    private String userPassword;
    public LoginUser() {}
    public LoginUser(String userId, String userPassword) {
        this.userId = userId;
        this.userPassword = userPassword;
    }
    public String getUserId() {
        return userId;
    }
    public String getUserPassword() {
        return userPassword;
    }
    
	@Override
	public String toString() {
		return "LoginUser [userId=" + userId + ", userPassword=" + userPassword + "]";
	}
}