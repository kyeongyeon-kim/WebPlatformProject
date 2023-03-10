package ohgym.userrequest;

import java.sql.Connection;
import java.sql.SQLException;

import ohgym.dbutil.ConnectionProvider;

public class UserResponseServiceImpl implements UserResponseService {
	private UserResponseDAO dao;
	public UserResponseServiceImpl(UserResponseDAO dao) {
		super();
		this.dao = dao;
	}
	@Override
	public String categoryName(String str) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			return dao.categoryName(str, conn);
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
	public String scoreNum(String str) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			return dao.scoreNum(str, conn);
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
	public String requestNum(String str) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			return dao.requestNum(str, conn);
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
	public String activeNum(String str) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			return dao.activeNum(str, conn);
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
	public String reviewNum(String str) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			return dao.reviewNum(str, conn);
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