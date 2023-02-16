package ohgym.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDAOImpl implements UserDAO {

	@Override
	public int insert(Connection conn, User user) {
		String sql = "INSERT INTO user (id, name, pw, phone, birthday, gender, usercheck) VALUES (?, ?, ?, ?, ?, ?, ?)";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, user.getId());
			stmt.setString(2, user.getName());
			stmt.setString(3, user.getPw());
			stmt.setString(4, user.getPhone());
			stmt.setString(5, user.getBirthday());
			stmt.setString(6, user.getGender());
			stmt.setInt(7, user.getUsercheck());
			
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("추가 작업 중 예외 발생", e);
		}
	}

	@Override
	public List<User> select(Connection conn) {
		String sql = "SELECT * FROM user";
		try (PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {
			List<User> list = new ArrayList<>();
			while (rs.next()) {
				list.add(resultMapping(rs));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("조회 작업 중 예외 발생", e);
		}
	}
	
	private User resultMapping(ResultSet rs) throws SQLException {
		User user = new User();
		user.setId(rs.getString("id"));
		user.setName(rs.getString("name"));
		user.setPw(rs.getString("pw"));
		user.setPhone(rs.getString("phone"));
		user.setBirthday(rs.getString("birthday"));
		user.setGender(rs.getString("gender"));
		user.setUsercheck(rs.getInt("usercheck"));
		return user;
	}

	@Override
	public User selectByUsercheck(Connection conn, int usercheck) {
		String sql = "SELECT * FROM user WHERE usercheck = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, usercheck);
			
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return resultMapping(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("조회 작업 중 예외 발생", e);
		}
		return null;
	}

	@Override
	public User selectById(Connection conn, String id) {
		String sql = "SELECT * FROM user WHERE id = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, id);
			
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return resultMapping(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("조회 작업 중 예외 발생", e);
		}
		return null;
	}

	@Override
	public int update(Connection conn, User user) {
		return -1;
	}

	@Override
	public int delete(Connection conn, String id) {
		String sql = "DELETE FROM user WHERE id = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, id);
			
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("삭제 작업 중 예외 발생", e);
		}
	}
}
