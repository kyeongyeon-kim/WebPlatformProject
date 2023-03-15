package ohgym.userrequest;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import ohgym.dbutil.ConnectionProvider;

@Service
public class RequestInfoServiceImpl implements RequestInfoService {
	private RequestInfoDAO dao;
	public RequestInfoServiceImpl(RequestInfoDAO dao) {
		super();
		this.dao = dao;
	}
	@Override
	public List<RequestInfo> selectRequestInfo(String user_id) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			return dao.selectRequestInfo(conn, user_id);
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
	@Override
	public List<RequestInfo> selectRequestInfoNoAll() {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			return dao.selectRequestInfoNoAll(conn);
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
	@Override
	public RequestInfo selectRequestInfoByNo(int no) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			return dao.selectRequestInfoByNo(conn,no);
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
