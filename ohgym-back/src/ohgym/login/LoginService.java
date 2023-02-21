package ohgym.login;

import java.sql.Connection;
import java.sql.SQLException;

import ohgym.dbutil.ConnectionProvider;
import ohgym.login.LoginDAO;
import ohgym.login.LoginDAOImpl;

public class LoginService {
    private final LoginDAO loginDAO;

    public LoginService(LoginDAO loginDAO) {
        this.loginDAO = loginDAO;
    }
    
    public boolean authenticate(String userId, String userPassword) {
        try (Connection conn = ConnectionProvider.getConnection()) {
            return loginDAO.authenticate(conn, userId, userPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
