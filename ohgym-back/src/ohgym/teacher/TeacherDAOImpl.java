package ohgym.teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherDAOImpl implements TeacherDAO {
	
	@Override
	public List<TeacherProfile> readTeacherProfile(Connection conn) {
		String sql = "select * from teacher_exercise as A" + 
				" left outer join teacher_introduction as B on A.id = B.id" + 
				" left outer join exercise_type as C on A.exercise_type = C.no" + 
				" left outer join teacher_service as D on A.no = D.teacher_no;";
		try (PreparedStatement stmt = conn.prepareStatement(sql); 
				ResultSet rs = stmt.executeQuery()) {
			List<TeacherProfile> list = new ArrayList<>();
			while (rs.next()) {
				list.add(resultMapping(rs));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("조회 작업 중 예외 발생", e);
		}
	}

	private TeacherProfile resultMapping(ResultSet rs) throws SQLException {
		TeacherProfile info = new TeacherProfile();
		info.setId(rs.getString("id"));
		info.setAppeal(rs.getString("appeal"));
		info.setContactTime(rs.getString("contact_time"));
		info.setExercise(rs.getString("exercise"));
		info.setIntroduction(rs.getString("introduction"));
		info.setCenterName(rs.getString("center_name"));
		info.setLocation(rs.getString("location"));
		info.setCareer(rs.getString("career"));
		info.setImage(rs.getString("image"));
		return info;
	}
	
	private TeacherProfile resultMapping_pick(ResultSet rs) throws SQLException {
		TeacherProfile info = new TeacherProfile();
		info.setId(rs.getString("id"));
		info.setAppeal(rs.getString("appeal"));
		info.setContactTime(rs.getString("contact_time"));
//		info.setExercise("null");
//		info.setIntroduction("null");
//		info.setCenterName("null");
//		info.setLocation("null");
//		info.setCareer("null");
		info.setImage(rs.getString("image"));
		return info;
	}

	@Override
	public List<TeacherProfile> readTeacherProfileByLocation(Connection conn, String location) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TeacherProfile> readTeacherProfileByType(Connection conn, String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TeacherProfile> readTeacherProfileById(Connection conn, String id) {
		String sql = "select * from teacher_exercise as A" 
				+ " left outer join teacher_introduction as B on A.id = B.id"
				+ " left outer join exercise_type as C on A.exercise_type = C.no"
				+ " left outer join teacher_service as D on A.no = D.teacher_no" + " where A.id = '" + id + "';";
		try (PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
			List<TeacherProfile> list = new ArrayList<>();
			while (rs.next()) {
				list.add(resultMapping(rs));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("조회 작업 중 예외 발생", e);
		}
	}

	@Override
	public List<TeacherProfile> readTeacherProfileByUserPick(Connection conn, String userId) {
		String sql = "select * from wish as A" 
				+ " left outer join teacher_introduction as B on A.teacher_id=B.id"
				+ " WHERE user_id= '"+userId+"';";
		System.out.println("여기까지오냐"+userId);
		try (PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
			System.out.println(rs);
			List<TeacherProfile> list = new ArrayList<>();
			while (rs.next()) {
				list.add(resultMapping_pick(rs));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("조회 작업 중 예외 발생", e);
		}
	}
		

	@Override
	public int insertTeacherProfile(Connection conn, TeacherProfile profile) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateTeacherProfile(Connection conn, TeacherProfile profile) {
		String sql = "UPDATE teacher_exercise as A" + 
				" left outer join teacher_introduction as B on A.id = B.id" + 
				" left outer join exercise_type as C on A.exercise_type = C.no" + 
				" left outer join teacher_service as D on A.no = D.teacher_no" + 
				" SET B.appeal = ?, B.contact_time = ?, A.exercise_type = ?," + 
				" D.introduction = ?, D.center_name = ?, D.location = ?, D.career = ?" + 
				" WHERE A.id = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, profile.getAppeal());
			stmt.setString(2, profile.getContactTime());
			stmt.setString(3, profile.getExercise());
			stmt.setString(4, profile.getIntroduction());
			stmt.setString(5, profile.getCenterName());
			stmt.setString(6, profile.getLocation());
			stmt.setString(7, profile.getCareer());
			stmt.setString(8, profile.getId());
			
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public int deleteTeacherProfile(Connection conn, String id, String type) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String convertExerciseTypeToExercise(Connection conn, String exerciseType) {
		String sql = "SELECT exercise FROM exercise_type WHERE no = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, exerciseType);
			try(ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return rs.getString("exercise");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("조회 작업 중 예외 발생", e);
		}
		return null;
	}

	@Override
	public String convertExerciseToExerciseType(Connection conn, String exercise) {
		String sql = "SELECT no FROM exercise_type WHERE exercise = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, exercise);
			try(ResultSet rs = stmt.executeQuery()) {
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

}
