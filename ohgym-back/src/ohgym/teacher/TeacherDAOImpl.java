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

	@Override
	public List<TeacherProfile> readTeacherProfile(Connection conn) {
		String sql = "UPDATE teacher_exercise as A" + 
				" left outer join teacher_introduction as B on A.id = B.id" + 
				" left outer join teacher_image as C on A.id = C.id" + 
				" left outer join exercise_type as D on A.exercise_type = D.no" + 
				" left outer join teacher_service as E on A.no = E.teacher_no" + 
				" SET B.appeal = ?, B.contact_time = ?, A.exercise_type = ?," + 
				" E.introduction = ?, E.center_name = ?, E.location = ?, E.career = ?" + 
				" WHERE A.id = ?";
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
		String sql = "select * from teacher_exercise as A" + " left outer join teacher_introduction as B on A.id = B.id"
				+ " left outer join teacher_image as C on A.id = C.id"
				+ " left outer join exercise_type as D on A.exercise_type = D.no"
				+ " left outer join teacher_service as E on A.no = E.teacher_no" + " where A.id = " + id + ";";
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
	public int insertTeacherProfile(Connection conn, TeacherProfile profile) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateTeacherProfile(Connection conn, TeacherProfile profile) {
		String sql = "UPDATE teacher_exercise as A" + 
				" left outer join teacher_introduction as B on A.id = B.id" + 
				" left outer join teacher_image as C on A.id = C.id" + 
				" left outer join exercise_type as D on A.exercise_type = D.no" + 
				" left outer join teacher_service as E on A.no = E.teacher_no" + 
				" SET B.appeal = ?, B.contact_time = ?, A.exercise_type = ?," + 
				" E.introduction = ?, E.center_name = ?, E.location = ?, E.career = ?" + 
				" WHERE A.id = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, profile.getAppeal());
			stmt.setString(2, profile.getContactTime());
			stmt.setString(3, "e5");
			stmt.setString(4, profile.getIntroduction());
			stmt.setString(5, profile.getCenterName());
			stmt.setString(6, profile.getLocation());
			stmt.setString(7, profile.getId());
			
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
}
