package ohgym.userresponse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserResponseDAOImpl implements UserResponseDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// 종목명
	@Override
	public String categoryName(String str) {
		String sql = "SELECT exercise FROM exercise_type WHERE no = '" + str + "'";
		try (PreparedStatement stmt = conn.prepareStatement(sql)){
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getString("exercise");
			}
		}
		return null;
	}
	// 평점
	@Override
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
	}
}