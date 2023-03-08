package ohgym.signup;

import java.sql.Connection;

import ohgym.dbutil.ConnectionProvider;

public class SignupServiceImpl implements SignupService {
    private SignupDAO signupDAO;
    
    public SignupServiceImpl(SignupDAO signupDAO) {
        this.signupDAO = signupDAO;
    }
    
    public boolean isDuplicatedId(String userId) {
    	try (Connection conn = ConnectionProvider.getConnection()) {
    		return signupDAO.isDuplicatedId(conn, userId);
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
