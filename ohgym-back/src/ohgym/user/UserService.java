package ohgym.user;

import java.util.List;

public interface UserService {

	User readUserInfo(String id);
	int updateUser(User user);
	int deleteUser(String id);
	
}
