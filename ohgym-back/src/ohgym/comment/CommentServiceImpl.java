package ohgym.comment;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import ohgym.dbutil.ConnectionProvider;

public class CommentServiceImpl implements CommentService {
	private CommentDAO dao;
	
	public CommentServiceImpl(CommentDAO dao) {
		super();
		this.dao = dao;
	}

	@Override
	public int commentInsert(CommentInfo commentInfo) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			return dao.commentInsert(conn, commentInfo);
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
		return 0;
	}

	@Override
	public List<CommentInfo> userComment(String user_id) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			return dao.userComment(conn, user_id);
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
	public List<CommentInfo> teacherComment(String teacher_id) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			return dao.teacherComment(conn, teacher_id);
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
	public List<CommentInfo> allComment() {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			return dao.allComment(conn);
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
