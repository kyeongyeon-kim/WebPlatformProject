package ohgym.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDAOImpl implements LoginDAO {
	@Autowired
	private JdbcTemplate jdbctemplate;
	
	
	@Override
	public boolean authenticate(String userId, String userPassword) {
		System.out.println("dao");
		Integer result = jdbctemplate.queryForObject("SELECT COUNT(*) FROM user WHERE id = ? AND pw = ?", Integer.class, userId, userPassword);
		System.out.println("dao");
		return result != null && result == 1;
	}
}