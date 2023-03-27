package ohgym.userresponse;

import java.sql.Connection;
import java.sql.SQLException;

public interface UserResponseDAO {
	String categoryName(String str);
	String scoreNum(String str);
	String requestNum(String str);
	String activeNum(String str);
	String reviewNum(String str);
}
