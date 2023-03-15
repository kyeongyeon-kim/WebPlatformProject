package ohgym.teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import ohgym.dbutil.ConnectionProvider;

@Service
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
	
	@Override
	public List<TeacherProfile> readUserPickTeacherProfile(String id) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			return dao.readTeacherProfileByUserPick(conn, id);
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

	@Override
	public String convertExerciseTypeToExercise(String exerciseType) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			return dao.convertExerciseTypeToExercise(conn, exerciseType);
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
	public String convertExerciseToExerciseType(String exercise) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			return dao.convertExerciseToExerciseType(conn, exercise);
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

	
}
