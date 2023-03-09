package ohgym.userrequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ohgym.dbutil.ConnectionProvider;

public interface RequestInfoDAO {
	List<RequestInfo> selectRequestInfo(Connection conn, String user_id) throws SQLException;
	List<RequestInfo> selectRequestInfoNoAll(Connection conn) throws SQLException;
}