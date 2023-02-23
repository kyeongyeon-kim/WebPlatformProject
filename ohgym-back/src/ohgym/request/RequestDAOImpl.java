package ohgym.request;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RequestDAOImpl implements RequestDAO {

	@Override
	public List<Request> selectRequest(Connection conn) throws SQLException {
		String sql = "select * from request as A" 
				+ " left outer join exercise_type as B on A.exercise_type = B.no;";
		try (PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
			List<Request> list = new ArrayList<>();
			while (rs.next()) {
				list.add(resultMapping(rs));
			}
			return list;
		}
	}
	
	@Override
	public List<Request> selectRequestById(Connection conn, String id) throws SQLException {
		String sql = "select * from request as A" 
				+ " left outer join exercise_type as B on A.exercise_type = B.no"
				+ " WHERE id = '" + id + "';";
		try (PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
			List<Request> list = new ArrayList<>();
			while (rs.next()) {
				list.add(resultMapping(rs));
			}
			return list;
		}
	}
	
	private Request resultMapping(ResultSet rs) throws SQLException {
		Request request = new Request();
		request.setNo(rs.getInt("request_no"));
		request.setId(rs.getString("user_id"));
		request.setExerciseType(rs.getString("exercise"));
		request.setRequestDate(rs.getString("request_date"));
		request.setDeadlineDate(rs.getString("deadline_date"));
		request.setMessage(rs.getString("message"));
		return request;
	}

	@Override
	public Request selectRequestByNo(Connection conn, int no) throws SQLException {
		String sql = "select * from request as A" 
				+ " left outer join exercise_type as B on A.exercise_type = B.no"
				+ " WHERE request_no = '" + no + "';";
		try (PreparedStatement stmt = conn.prepareStatement(sql); 
				ResultSet rs = stmt.executeQuery()) {
			Request req = new Request();
			while (rs.next()) {
				req = resultMapping(rs);
			}
			return req;
		}
	}
}
