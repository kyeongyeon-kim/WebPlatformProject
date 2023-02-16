package ohgym.teacher;

import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ohgym.user.User;


public class TeacherDAOImpl implements TeacherDAO {
	// teacher_introduction
	@Override
	public int insertIntroduction(Connection conn, TeacherInfo info) {
		String sql = "INSERT INTO teacher_introduction (id, contact_time, appeal) VALUES (?, ?, ?)";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, info.getId());
			stmt.setString(2, info.getContact_time());
			stmt.setString(3, info.getAppeal());
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("추가 작업 중 예외 발생", e);
		}
	}

	@Override
	public List<TeacherInfo> selectInfo(Connection conn) {
		String sql = "SELECT * FROM teacher_introduction";
		try (PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {
			List<TeacherInfo> list = new ArrayList<>();
			while (rs.next()) {
				list.add(resultMapping(rs));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("조회 작업 중 예외 발생", e);
		}
	}
	
	private TeacherInfo resultMapping(ResultSet rs) throws SQLException {
		TeacherInfo info = new TeacherInfo();
		info.setId(rs.getString("id"));
		info.setContact_time(rs.getString("contact_time"));
		info.setAppeal(rs.getString("appeal"));
		return info;
	}

	@Override
	public TeacherInfo selectInfoById(Connection conn, String id) {
		String sql = "SELECT * FROM teacher_introduction WHERE id = ?";
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
	public int updateInfo(Connection conn, TeacherInfo info) {
		return 0;
	}

	@Override
	public int deleteInfo(Connection conn, String id) {
		return 0;
	}
	
	// teacher_exercise 
	@Override
	public int insertExercise(Connection conn, String id, String type) {
		return 0;
	}
	@Override
	public int updateExercise(Connection conn, String id, String type) {
		return 0;
	}
	@Override
	public int deleteExercise(Connection conn, String id, String type) {
		return 0;
	}

	@Override
	public String getTeacherExerciseNo(Connection conn, String id, String type) {
		String sql = "SELECT * FROM teacher_exercise WHERE id = ? AND exercise_type = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, id);
			stmt.setString(2, type);
			
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return rs.getString("no");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("조회 작업 중 예외 발생", e);
		}
		return null;
	}

	// teacher_service
	@Override
	public int insertExerciseInfo(Connection conn, TeacherExercise service) {
		String sql = "INSERT INTO teacher_service (teacher_no, location, career, introduction) VALUES (?, ?, ?, ?)";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, getTeacherExerciseNo(conn, service.getId(), service.getExercise_type()));
			stmt.setString(2, service.getLocation());
			stmt.setString(3, service.getCareer());
			stmt.setString(3, service.getIntroduction());
			
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("추가 작업 중 예외 발생", e);
		}
	}
	
	@Override
	public List<TeacherExercise> selectExerciseInfo(Connection conn) {
		return null;
	}

	@Override
	public TeacherExercise selectExerciseInfoById(Connection conn, String id) {
		return null;
	}

	@Override
	public TeacherExercise selectExerciseInfoByType(Connection conn, String type) {
		return null;
	}

	@Override
	public int updateExerciseInfo(Connection conn, TeacherExercise exercise) {
		return 0;
	}
	
	@Override
	public int deleteExerciseInfo(Connection conn, String id, String type) {
		return 0;
	}

	// teacher_image
	@Override
	public int insertImage(Connection conn, TeacherImage image) {
		return 0;
	}

	@Override
	public Image selectImageById(Connection conn, String id) {
		return null;
	}

	@Override
	public int updateImage(Connection conn, Image image) {
		return 0;
	}

	@Override
	public int deleteImage(Connection conn, String id) {
		return 0;
	}
<<<<<<< HEAD

	@Override
	public int insertExercise(Connection conn, String type) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertExerciseInfo(Connection conn, TeacherExercise exercise) {
		// TODO Auto-generated method stub
		return 0;
	}

=======
>>>>>>> branch 'master' of https://github.com/yeon966/WebFlatformProject.git
}
