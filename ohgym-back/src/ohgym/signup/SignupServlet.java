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
    private SignupService service;

    @Override
    public void init() throws ServletException {
        super.init();
        service = new SignupService(new SignupDAOImpl());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userId = request.getParameter("memberid");
        String userPassword = request.getParameter("password");
        String userName = request.getParameter("userName");
        String userPhone = request.getParameter("userPhone");
        String userBirthday = request.getParameter("userBirthday");
        String userGender = request.getParameter("userGender");
        int usercheck = 1;
        
        String idPattern = "[a-zA-Z0-9_-]{1,10}";
        String passwordPattern = "[a-zA-Z0-9_-]{1,10}";
        String namePattern = "[ㄱ-힣]{1,10}";
        String phonePattern = "[0-9]{10,11}";
        String birthdayPattern = "[0-9]{8}";
        
        boolean isIdDuplicated = service.isDuplicatedId(userId); //여기

        if (isIdDuplicated) {
            request.setAttribute("error", "중복된 아이디입니다!!!!!!");
            request.getRequestDispatcher("/signup").forward(request, response);
        }
        
        if (userId == null || !userId.matches(idPattern)) {
            request.setAttribute("error", "아이디 잘못적음");
            request.getRequestDispatcher("/signup").forward(request, response);
            return;
        }
        
        if (!userPassword.matches("^[a-zA-Z0-9_-]{1,10}$")) {
			response.getWriter().println("비밀번호 잘못적음");
			return;
		}
        
        SignupUser signupUser = new SignupUser(userId, userPassword, userName, userPhone, 
        		userBirthday, userGender, usercheck);

        int result = service.insertUser(signupUser);

        if (result != 0) {
            //response.sendRedirect("signupSuccess.jsp");
        	String redirectUrl = "https://www.naver.com/";
        	response.sendRedirect(redirectUrl);
        } else {
            //response.sendRedirect("signupFail.jsp");
        	response.getWriter().write("회원가입 실패했다");
        }
    }
}