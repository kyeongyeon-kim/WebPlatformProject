package ohgym.signup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import ohgym.dbutil.ConnectionProvider;

public class SignupDAOImpl implements SignupDAO {
	private Connection conn;

	@Override
	public int insertUser(SignupUser signupUser) {
		int result = 0;
		PreparedStatement pstmt = null;
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(
					"INSERT INTO user(id, pw, name, phone, birthday, gender, usercheck) VALUES (?, ?, ?, ?, ?, ?, ?)");
			pstmt.setString(1, signupUser.getUserId());
			pstmt.setString(2, signupUser.getUserPassword());
			pstmt.setString(3, signupUser.getUserName());
			pstmt.setString(4, signupUser.getUserPhone());
			pstmt.setString(5, signupUser.getUserBirthday());
			pstmt.setString(6, signupUser.getUserGender());
			pstmt.setInt(7, signupUser.getUsercheck());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean isDuplicatedId(Connection conn, String userId) {
		boolean isDuplicated = false;
		try (PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM user WHERE id = ?")) { // 여기
			pstmt.setString(1, userId);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					isDuplicated = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isDuplicated;
	}

}