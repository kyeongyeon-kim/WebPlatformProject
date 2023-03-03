package ohgym.comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ohgym.dbutil.ConnectionProvider;

public class CommentDAO {
	public void commentInsert(CommentInfo commentInfo) {
		String sql = "INSERT INTO comment VALUES (?, ?, ?, ?);";
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.setString(1, commentInfo.getUser_id());
			stmt.setString(2, commentInfo.getTeacher_id());
			stmt.setDouble(3, commentInfo.getScore());
			stmt.setString(4, commentInfo.getReview());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<CommentInfo> userComment(String user_id) {
		List<CommentInfo> commentList = new ArrayList<>();
		String sql = "SELECT * FROM comment WHERE user_id = '" + user_id + "'";
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)){
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				CommentInfo commentInfo = new CommentInfo();
				commentInfo.setNo(rs.getInt("no"));
				commentInfo.setUser_id(rs.getString("user_id"));
				commentInfo.setTeacher_id(rs.getString("teacher_id"));
				commentInfo.setScore(rs.getDouble("score"));
				commentInfo.setReview(rs.getString("review"));
				commentList.add(commentInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return commentList;
	}
	public List<CommentInfo> teacherComment(String teacher_id) {
		List<CommentInfo> commentList = new ArrayList<>();
		String sql = "SELECT * FROM comment WHERE teacher_id = '" + teacher_id + "'";
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)){
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				CommentInfo commentInfo = new CommentInfo();
				commentInfo.setNo(rs.getInt("no"));
				commentInfo.setUser_id(rs.getString("user_id"));
				commentInfo.setTeacher_id(rs.getString("teacher_id"));
				commentInfo.setScore(rs.getDouble("score"));
				commentInfo.setReview(rs.getString("review"));
				commentList.add(commentInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return commentList;
	}
	public List<CommentInfo> allComment() {
		List<CommentInfo> commentList = new ArrayList<>();
		String sql = "SELECT * FROM comment";
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)){
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				CommentInfo commentInfo = new CommentInfo();
				commentInfo.setNo(rs.getInt("no"));
				commentInfo.setUser_id(rs.getString("user_id"));
				commentInfo.setTeacher_id(rs.getString("teacher_id"));
				commentInfo.setScore(rs.getDouble("score"));
				commentInfo.setReview(rs.getString("review"));
				commentList.add(commentInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return commentList;
	}
	
}