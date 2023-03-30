package ohgym.user;

public interface UserService {

	User readUserInfo(String id);
	int updateUser(User user);
	int deleteUser(String id);
	
}
