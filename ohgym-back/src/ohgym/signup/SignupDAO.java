package ohgym.signup;

import java.sql.Connection;

public interface SignupDAO {
	//회원가입 정보 DB 추가
	public int insertUser(SignupUser user);
	
	//아니다 이거
	public SignupUser getUserById(String userId);
	
	//아이디 중복체크
	public boolean isDuplicatedId(Connection conn, String userId);
	
	//아이디 유효성 검사
	public boolean validationId(Connection conn, String userId);
	
	//비밀번호 유효성 검사
	public boolean validationPassword(Connection conn, String userPassword);
	public boolean validationName(Connection conn, String userName);
	public boolean validationPhone(Connection conn, String userPhone);
	public boolean validationBirthday(Connection conn, String userBirthday);
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
