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
		String sql = "SELECT * FROM request";
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
		String sql = "SELECT * FROM request WHERE id = '" + id + "';";
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
		request.setNo(rs.getString("no"));
		request.setId(rs.getString("user_id"));
		request.setExerciseType(rs.getString("exercise_type"));
		request.setRequestDate(rs.getString("request_date"));
		request.setDeadlineDate(rs.getString("deadline_date"));
		request.setMessage(rs.getString("message"));
		return request;
	}
}
