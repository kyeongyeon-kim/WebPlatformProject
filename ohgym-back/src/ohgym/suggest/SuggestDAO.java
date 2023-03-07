package ohgym.suggest;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

public interface SuggestDAO {
	List<Suggest> selectSuggest(Connection conn) throws SQLException;
	int insertSuggest(Connection conn, Suggest suggest) throws SQLException;
	
//	List<Suggest> selectTeacherId(Connection conn) throws SQLException;
}
