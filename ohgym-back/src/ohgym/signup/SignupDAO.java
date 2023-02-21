package ohgym.signup;

import java.sql.Connection;

public interface SignupDAO {
	public int insertUser(SignupUser user);
	public boolean isDuplicatedId(Connection conn, String userId);
	public SignupUser getUserById(String userId);
}
