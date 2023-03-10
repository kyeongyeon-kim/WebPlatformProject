package ohgym.userrequest;

import java.sql.Connection;
import java.sql.SQLException;

public interface UserRequestDAO { 
	void requestAdd(String user_id, String exercise_type, String str, Connection conn) throws SQLException;
	void requestAnswerAdd(String[] arr, Connection conn) throws SQLException;
}
