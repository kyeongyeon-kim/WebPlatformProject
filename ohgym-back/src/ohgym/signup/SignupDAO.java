package ohgym.signup;

import java.sql.Connection;

public interface SignupDAO {
	
	public int insertUser(SignupUser user);
	public boolean isDuplicatedId(Connection conn, String userId);
	public SignupUser getUserById(String userId);
	
	public boolean validationId(Connection conn, String userId);
	public boolean validationPassword(Connection conn, String userId);
	public boolean validation(Connection conn, String userId);
	public boolean validationId(Connection conn, String userId);
	public boolean validationId(Connection conn, String userId);
}



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
