package ohgym.user;

import java.sql.Connection;
import java.util.List;

public interface UserDAO {
	int insert(User user);
	List<User> select();
	User selectByUsercheck(int usercheck);
	User selectById(String id);
	int update(User user);
	int delete(String id);
}
