package ohgym.user;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO dao;

	@Override
	public User readUserInfo(String id) {
		return dao.selectById(id);
	}

	@Override
	public int updateUser(User user) {
		return dao.update(user);
		
	}

	@Override
	public int deleteUser(String id) {
		return dao.delete(id);
	}
}
