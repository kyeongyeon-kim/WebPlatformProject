package ohgym.detailRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SuggestDAOImpl implements SuggestDAO {
	@Override
	public List<Suggest> selectSuggest (Connection conn) throws SQLException {
		String sql = "SELECT * FROM suggest AS A" +
				" LEFT OUTER JOIN request AS B ON A.request_no = B.request_no;";
		try (PreparedStatement stmt = conn.prepareStatement(sql); 
				ResultSet rs = stmt.executeQuery()) {
			List<Suggest> list = new ArrayList<>();
			while (rs.next()) {
				list.add(resultMapping(rs));
				System.out.println(list);
			}
			
			return list;
		}
	}
	
	private Suggest resultMapping(ResultSet rs) throws SQLException {
		Suggest suggest = new Suggest();
		suggest.setNo(Integer.valueOf(rs.getString("suggest_no")));
		suggest.setId(rs.getString("teacher_id"));
		suggest.setRequestNo(rs.getString("request_no"));
		suggest.setPrice(Integer.valueOf(rs.getString("price")));
		suggest.setDate(rs.getString("date"));
		suggest.setMessage(rs.getString("message"));
		return suggest;
	}
}
