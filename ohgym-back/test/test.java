import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ohgym.dbutil.ConnectionProvider;
import ohgym.teacher.TeacherDAO;

public class test {
	private static TeacherDAO dao;
	private Connection conn;

	@BeforeClass
	public static void setup() {
		dao = new TeacherDAO();
	}

	@Before
	public void makeConn() throws SQLException {
		conn = ConnectionProvider.getConnection();
		conn.setAutoCommit(false);
	}
}
