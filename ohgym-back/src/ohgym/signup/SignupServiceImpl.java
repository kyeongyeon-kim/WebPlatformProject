package ohgym.signup;

import java.sql.Connection;

import org.springframework.beans.factory.annotation.Autowired;


public class SignupServiceImpl implements SignupService {
    @Autowired
	private SignupDAO signupDAO;
    
    
    public boolean isDuplicatedId(String userId) {
    		return signupDAO.isDuplicatedId(userId);	
    }

    public int insertUser(SignupUser signupUser) {
            return signupDAO.insertUser(signupUser);
    }
}
