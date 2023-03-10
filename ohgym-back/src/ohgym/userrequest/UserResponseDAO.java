package ohgym.userrequest;

import java.sql.Connection;
import java.sql.SQLException;

public interface UserResponseDAO {
	String categoryName(String str, Connection conn) throws SQLException;
	String scoreNum(String str, Connection conn) throws SQLException;
	String requestNum(String str, Connection conn) throws SQLException;
	String activeNum(String str, Connection conn) throws SQLException;
	String reviewNum(String str, Connection conn) throws SQLException;
}
