package ohgym.suggest;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import ohgym.dbutil.ConnectionProvider;

public class SuggestServiceImpl implements SuggestService {
	public SuggestDAO dao;
	
	public SuggestServiceImpl(SuggestDAO dao) {
		super();
		this.dao = dao;
	}
	
	@Override
	public List<Suggest> selectSuggest() {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			return dao.selectSuggest(conn);
		} catch (RuntimeException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}
