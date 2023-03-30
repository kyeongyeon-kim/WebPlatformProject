package ohgym.userrequest;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface RequestInfoDAO {
	List<RequestInfo> selectRequestInfo(String user_id) ;
	List<RequestInfo> selectRequestInfoNoAll() ;
	RequestInfo selectRequestInfoByNo(int no) ;
}