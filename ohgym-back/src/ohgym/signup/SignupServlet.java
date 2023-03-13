package ohgym.signup;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
    private final SignupServiceImpl service = new SignupServiceImpl(new SignupDAOImpl());
    
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/signup.jsp").forward(req, resp);
	}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userId = request.getParameter("userId");
        String userPassword = request.getParameter("userPassword");
        String userName = request.getParameter("userName");
        String userPhone = request.getParameter("userPhone");
        String userBirthday = request.getParameter("userBirthday");
        String userGender = request.getParameter("userGender");
        int usercheck = 1;
        
        boolean isIdDuplicated = service.isDuplicatedId(userId);
        
        System.out.println(userId);
        if (isIdDuplicated) {
			request.setAttribute("errorMessage", "중복된 아이디입니다!");
			request.getRequestDispatcher("/views/signup.jsp").forward(request, response);
			
        }

        SignupUser signupUser = new SignupUser(userId, userPassword, userName, userPhone, 
        		userBirthday, userGender, usercheck);

        int result = service.insertUser(signupUser);

        if (result != 0) {
        	String redirectUrl = "./login";
        	response.sendRedirect(redirectUrl);
        } else {
        	String redirectUrl = "./signup";
        	response.sendRedirect(redirectUrl);
        }
    }
}