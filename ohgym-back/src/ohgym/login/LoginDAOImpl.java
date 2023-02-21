package ohgym.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDAOImpl implements LoginDAO {
	@Override
	public boolean authenticate(Connection conn, String userId, String userPassword) {
		boolean result = false;
		try (PreparedStatement pstmt = conn
				.prepareStatement("SELECT COUNT(*) FROM user WHERE id = ? AND pw = ?")) {
			pstmt.setString(1, userId);
			pstmt.setString(2, userPassword);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				int count = rs.getInt(1);
				if (count == 1) {
					result = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}