package ohgym.userrequest;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface RequestInfoDAO {
	List<RequestInfo> selectRequestInfo(Connection conn, String user_id) throws SQLException;
	List<RequestInfo> selectRequestInfoNoAll(Connection conn) throws SQLException;
	RequestInfo selectRequestInfoByNo(Connection conn,int no) throws  SQLException;
}