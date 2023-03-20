package ohgym.teacher;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository
public class TeacherDAOImpl implements TeacherDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<TeacherProfile> rowMapper = new RowMapper<TeacherProfile>() {
		@Override
		public TeacherProfile mapRow(ResultSet rs, int rowNum) throws SQLException {
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
	};
	private RowMapper<TeacherProfile> rowMapper_pick = new RowMapper<TeacherProfile>() {
		@Override
		public TeacherProfile mapRow(ResultSet rs, int rowNum) throws SQLException {
			TeacherProfile info = new TeacherProfile();
			info.setId(rs.getString("id"));
			info.setAppeal(rs.getString("appeal"));
			info.setContactTime(rs.getString("contact_time"));
			info.setImage(rs.getString("image"));
			return info;
		}
	};
	
	@Override
	public List<TeacherProfile> readTeacherProfile() {
		String sql = "select * from teacher_exercise as A" + 
				" left outer join teacher_introduction as B on A.id = B.id" + 
				" left outer join exercise_type as C on A.exercise_type = C.no" + 
				" left outer join teacher_service as D on A.no = D.teacher_no;";	
		return jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public List<TeacherProfile> readTeacherProfileById(String id) {
		String sql = "select * from teacher_exercise as A" 
				+ " left outer join teacher_introduction as B on A.id = B.id"
				+ " left outer join exercise_type as C on A.exercise_type = C.no"
				+ " left outer join teacher_service as D on A.no = D.teacher_no" + " where A.id = '" + id + "';";
		return jdbcTemplate.query(sql, rowMapper_pick);
	}

	@Override
	public List<TeacherProfile> readTeacherProfileByUserPick(String userId) {
		String sql = "select * from wish as A" 
				+ " left outer join teacher_introduction as B on A.teacher_id=B.id"
				+ " WHERE user_id= '"+userId+"';";
		return jdbcTemplate.query(sql, rowMapper_pick);
	}

	@Override
	public int updateTeacherProfile(TeacherProfile profile) {
		String sql = "UPDATE teacher_exercise as A" + 
				" left outer join teacher_introduction as B on A.id = B.id" + 
				" left outer join exercise_type as C on A.exercise_type = C.no" + 
				" left outer join teacher_service as D on A.no = D.teacher_no" + 
				" SET B.appeal = ?, B.contact_time = ?, A.exercise_type = ?," + 
				" D.introduction = ?, D.center_name = ?, D.location = ?, D.career = ?" + 
				" WHERE A.id = ?";
		return jdbcTemplate.update(sql, profile.getAppeal(), profile.getContactTime()
				, profile.getExercise(), profile.getIntroduction(), profile.getCenterName()
				, profile.getLocation(), profile.getCareer(), profile.getId());	
	}

	@Override
	public String convertExerciseTypeToExercise(String exerciseType) {
		String sql = "SELECT exercise FROM exercise_type WHERE no = ?";
		return jdbcTemplate.queryForObject(sql, String.class, exerciseType);	
	}

	@Override
	public String convertExerciseToExerciseType(String exercise) {
		String sql = "SELECT no FROM exercise_type WHERE exercise = ?";
		return jdbcTemplate.queryForObject(sql, String.class, exercise);
	}
}
