package ohgym.teacher;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import ohgym.dbutil.ConnectionProvider;

public class TeacherServiceImpl implements TeacherService {
	private TeacherDAO dao;

	public TeacherServiceImpl(TeacherDAO dao) {
		super();
		this.dao = dao;
	}

	// TeacherProfileRead
	@Override
	public List<TeacherProfile> readTeacherProfile(String id) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			return dao.readTeacherProfileById(conn, id);
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
		return null;
	}

	@Override
	public List<TeacherProfile> readAllTeacherProfile() {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			return dao.readTeacherProfile(conn);
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
		return null;
	}
	
	// updateTeacherProfile
	@Override
	public int updateTeacherProfile(TeacherProfile teacherProfile) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			return dao.updateTeacherProfile(conn, teacherProfile);
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
		return 0;
	}
}
