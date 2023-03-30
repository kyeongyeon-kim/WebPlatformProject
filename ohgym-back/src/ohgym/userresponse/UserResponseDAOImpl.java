package ohgym.userresponse;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
<<<<<<< HEAD
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
=======

>>>>>>> 7523e6bd2897de66ac9b529820d97ca8617d1410
public class UserResponseDAOImpl implements UserResponseDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
<<<<<<< HEAD
	private RowMapper<String> rowMapper = new RowMapper<String>() {
		@Override
		public String mapRow(ResultSet rs, int rowNum) throws SQLException {
			List<String> list = new ArrayList<>();
			list.add(rs.getString("categoryName"));
			list.add(rs.getString("requestNum"));
			list.add(rs.getString("scoreNum"));
			list.add(rs.getString("reviewNum"));
			list.add(rs.getString("activeNum"));
			return String.join(", ", list);
=======
	// 종목명
	@Override
	public String categoryName(String str) {
		String sql = "SELECT exercise FROM exercise_type WHERE no = '" + str + "'";
		try (PreparedStatement stmt = conn.prepareStatement(sql)){
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getString("exercise");
			}
>>>>>>> 7523e6bd2897de66ac9b529820d97ca8617d1410
		}
	};
	
	@Override
<<<<<<< HEAD
	public List<String> responseList(String str){
		String sql = "SELECT exercise_type.exercise AS categoryName, " 
		+ "(SELECT avg(score)FROM ohgym.comment WHERE ohgym.comment.teacher_id IN "
			+ "(SELECT teacher_exercise.id FROM teacher_exercise WHERE exercise_type = " + str + "))  AS scoreNum, " 
		+ "(SELECT count(*) FROM request WHERE request.exercise_type = " + str + ") AS requestNum, "
		+ "(SELECT count(*) FROM teacher_exercise WHERE teacher_exercise.exercise_type = " + str + ") AS activeNum, " 
		+ "(SELECT count(*) FROM ohgym.comment WHERE ohgym.comment.teacher_id IN "
			+ "(SELECT teacher_exercise.id FROM teacher_exercise WHERE exercise_type = " + str + ")) AS reviewNum " 
		+ "FROM exercise_type WHERE exercise_type.no = " + str;
		return jdbcTemplate.query(sql, rowMapper);
=======
	public String scoreNum(String str) {
		String sql = "SELECT avg(score) FROM comment WHERE teacher_id IN (SELECT id FROM teacher_exercise WHERE exercise_type = '" + str + "')";
		try (PreparedStatement stmt = conn.prepareStatement(sql)){
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return String.valueOf(rs.getDouble("avg(score)"));
			}
		}
		return null;
	}
	// 요청서 수
	@Override
	public String requestNum(String str) {
		String sql = "SELECT count(*) FROM request WHERE exercise_type = '" + str + "'";
		try (PreparedStatement stmt = conn.prepareStatement(sql)){
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return String.valueOf(rs.getInt("count(*)"));
			}
		}
		return null;
	}
	// 활동 선생 수
	@Override
	public String activeNum(String str) {
		String sql = "SELECT count(*) FROM teacher_exercise WHERE exercise_type = '" + str + "'";
		try (PreparedStatement stmt = conn.prepareStatement(sql)){
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return String.valueOf(rs.getInt("count(*)"));
			}
		}
		return null;
	}
	// 리뷰 수
	@Override
	public String reviewNum(String str) {
		String sql = "SELECT count(*) FROM comment WHERE teacher_id IN (SELECT id FROM teacher_exercise WHERE exercise_type = '" + str + "')";
		try (PreparedStatement stmt = conn.prepareStatement(sql)){
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return String.valueOf(rs.getInt("count(*)"));
			}
		}
		return null;
>>>>>>> 7523e6bd2897de66ac9b529820d97ca8617d1410
	}
}