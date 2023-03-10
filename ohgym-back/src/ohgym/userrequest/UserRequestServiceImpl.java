package ohgym.userrequest;

import java.sql.Connection;
import java.sql.SQLException;

import ohgym.dbutil.ConnectionProvider;

public class UserRequestServiceImpl implements UserRequestService {
	private UserRequestDAO dao;
	    
    public UserRequestServiceImpl(UserRequestDAO dao) {
        this.dao = dao;
    }

    public void requestAdd(String user_id, String exercise_type, String str) throws SQLException {
    	Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			dao.requestAdd(user_id, exercise_type, str, conn);
		} catch (RuntimeException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
    }

    public void requestAnswerAdd(String[] arr) throws SQLException {
        try (Connection conn = ConnectionProvider.getConnection()) {
            dao.requestAnswerAdd(arr, conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
