package ohgym.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ohgym.request.Request;

@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
	
	
	@Override
	public int insert(User user) {
		String sql = "INSERT INTO user (id, name, pw, phone, birthday, gender, usercheck) VALUES (?, ?, ?, ?, ?, ?, ?)";
		return jdbcTemplate.update(sql, rowMapper
				, user.getId()
				, user.getName()
				, user.getPw()
				, user.getPhone()
				, user.getBirthday()
				, user.getGender()
				, user.getUsercheck());
	}

	@Override
	public List<User> select() {
		return jdbcTemplate.query("SELECT * FROM user",rowMapper);
	}
	
	@Override
	public User selectByUsercheck(int usercheck) {
		String sql = "SELECT * FROM user WHERE usercheck = '"+usercheck+"';";
		return (User) jdbcTemplate.query(sql, rowMapper); 
	}

	@Override
	public User selectById(String id) {
		String sql = "SELECT * FROM user WHERE id = '"+id+"';";
		return (User) jdbcTemplate.query(sql, rowMapper);
		
	}

	@Override
	public int update(User user) {
		String sql = "UPDATE user SET name = ?,pw = ?,phone = ?,birthday = ?,gender =? WHERE id = ?";
		return jdbcTemplate.update(sql, rowMapper
				, user.getName()
				, user.getPw()
				, user.getPhone()
				, user.getBirthday()
				, user.getGender()
				, user.getId());	
	}	
		
	@Override
	public int delete(String id) {
		String sql = "DELETE FROM user WHERE id = ?";
		return jdbcTemplate.update(sql, id);
	}
}
