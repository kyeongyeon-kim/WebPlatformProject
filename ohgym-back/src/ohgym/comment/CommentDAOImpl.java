package ohgym.comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ohgym.dbutil.ConnectionProvider;
import ohgym.teacher.TeacherProfile;

public class CommentDAOImpl implements CommentDAO {
	public int commentInsert(Connection conn, CommentInfo commentInfo) {
		String sql = "INSERT INTO ohgym.comment (user_id, teacher_id, score, review) VALUES (?, ?, ?, ?)";

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, commentInfo.getUser_id());
			stmt.setString(2, commentInfo.getTeacher_id());
			stmt.setDouble(3, commentInfo.getScore());
			stmt.setString(4, commentInfo.getReview());
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<CommentInfo> userComment(Connection conn, String user_id) {
		List<CommentInfo> commentList = new ArrayList<>();
		String sql = "SELECT * FROM comment WHERE user_id = '" + user_id + "'";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				commentList.add(resultMapping(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return commentList;
	}

	public List<CommentInfo> teacherComment(Connection conn, String teacher_id) {
		List<CommentInfo> commentList = new ArrayList<>();
		String sql = "SELECT * FROM comment WHERE teacher_id = '" + teacher_id + "'";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				commentList.add(resultMapping(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return commentList;
	}

	public List<CommentInfo> allComment(Connection conn) {
		List<CommentInfo> commentList = new ArrayList<>();
		String sql = "SELECT * FROM comment";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				commentList.add(resultMapping(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return commentList;
	}
	
	private CommentInfo resultMapping(ResultSet rs) throws SQLException {
		CommentInfo commentInfo = new CommentInfo();
		commentInfo.setNo(rs.getInt("no"));
		commentInfo.setUser_id(rs.getString("user_id"));
		commentInfo.setTeacher_id(rs.getString("teacher_id"));
		commentInfo.setScore(rs.getDouble("score"));
		commentInfo.setReview(rs.getString("review"));
		return commentInfo;
	}
}
