package ohgym.signup;

import java.sql.Connection;

import ohgym.dbutil.ConnectionProvider;

public class SignupService {
    private SignupDAO signupDAO;
    
    public SignupService(SignupDAO signupDAO) {
        this.signupDAO = signupDAO;
    }
    
    public boolean isDuplicatedId(String userId) {
    	try (Connection conn = ConnectionProvider.getConnection()) {
    		return signupDAO.isDuplicatedId(conn, userId); //여기
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return false;
    }

    public int insertUser(SignupUser signupUser) {
        try (Connection conn = ConnectionProvider.getConnection()) {
            return signupDAO.insertUser(signupUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
