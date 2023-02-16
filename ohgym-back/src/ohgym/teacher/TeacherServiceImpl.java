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
	// TeacherProfileRead
	@Override
	public TeacherProfile readTeacherProfile(String id) {

		try(Connection conn = ConnectionProvider.getConnection()) {
			TeacherInfo teacherInfo = dao.selectInfoById(conn, id);
			TeacherExercise teacherExercise =  dao.selectExerciseInfoById(conn, id);
			List<String> typeList = dao.selectExserciseTypeById(conn, id);
			List<String> exerciseList = null;
			for (String type : typeList) {
				exerciseList = dao.selectExserciseByType(conn, type);
				
			}
			String career = teacherExercise.getCareer();
			String centerName = teacherExercise.getCenter_name();
			String introduction = teacherExercise.getIntroduction();
			String location = teacherExercise.getLocation();
			String appeal = teacherInfo.getAppeal();
			String contactTime = teacherInfo.getContact_time();
			
			return new TeacherProfile(id, appeal, contactTime, exerciseList, introduction, centerName, location, career);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
