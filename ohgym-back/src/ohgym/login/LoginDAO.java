package ohgym.login;

public interface LoginDAO {
	public boolean authenticate(String userId, String userPassword);
}
