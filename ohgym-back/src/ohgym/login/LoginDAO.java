package ohgym.login;

import java.sql.Connection;

public interface LoginDAO {
	public boolean authenticate(Connection conn, String userId, String userPassword);
}
