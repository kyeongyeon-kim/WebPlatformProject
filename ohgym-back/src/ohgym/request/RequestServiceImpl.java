package ohgym.request;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import ohgym.dbutil.ConnectionProvider;

public class RequestServiceImpl implements RequestService {
	private RequestDAO dao;
	
	public RequestServiceImpl(RequestDAO dao) {
		super();
		this.dao = dao;
	}

	@Override
	public List<Request> selectRequest() {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			return dao.selectRequest(conn);
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
	public List<Request> selectRequestById(String id) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			return dao.selectRequestById(conn, id);
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
	public Request selectRequestByNo(int no) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			return dao.selectRequestByNo(conn, no);
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
