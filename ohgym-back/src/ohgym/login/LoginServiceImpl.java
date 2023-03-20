package ohgym.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginDAO loginDAO;

	public boolean authenticate(String userId, String userPassword) {
		return loginDAO.authenticate(userId, userPassword);
	}
}
