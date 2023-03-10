package ohgym.userrequest;

import java.sql.SQLException;

public interface UserRequestService {
    void requestAdd(String user_id, String exercise_type, String str) throws SQLException;
    void requestAnswerAdd(String[] arr) throws SQLException;
}
