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
	@Override
	public TeacherInfo createTeacherInfo(TeacherInfo info) {
		return null;
	}

	@Override
	public List<TeacherInfo> readTeacherInfo() {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			return dao.selectInfo(conn);
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
	public TeacherInfo updateTeacherInfo(TeacherInfo info) {
		return null;
	}

	@Override
	public TeacherInfo deleteTeacherInfo(String id) {
		return null;
	}

	@Override
	public String createExercise(String id, String type) {
		return null;
	}

	@Override
	public String updateExercise(String id, String type) {
		return null;
	}

	@Override
	public String deleteExercise(String id, String type) {
		return null;
	}

	@Override
	public TeacherExercise createTeacherExercise(TeacherExercise exercise) {
		return null;
	}

	@Override
	public List<TeacherExercise> readTeacherExercise() {
		return null;
	}

	@Override
	public TeacherExercise updateTeacherExercise(TeacherExercise exercise) {
		return null;
	}

	@Override
	public TeacherExercise deleteTeacherExercise(String id, String type) {
		return null;
	}
}
