package ohgym.user;

import java.sql.Connection;
import java.util.List;

public interface UserDAO {
	int insert(Connection conn, User user);
	List<User> select(Connection conn);
	User selectByUsercheck(Connection conn, int usercheck);
	User selectById(Connection conn, String id);
	int update(Connection conn, User user);
	int delete(Connection conn, String id);
}
