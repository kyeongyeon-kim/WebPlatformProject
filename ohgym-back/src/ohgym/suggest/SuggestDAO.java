package ohgym.suggest;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

public interface SuggestDAO {
	List<Suggest> selectSuggest(Connection conn) throws SQLException;

}
