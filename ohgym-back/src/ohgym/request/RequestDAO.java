package ohgym.request;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface RequestDAO {
	// (R) selectRequest
	List<Request> selectRequest(Connection conn) throws SQLException ;
	List<Request> selectRequestById(Connection conn, String id) throws SQLException;
	
}
