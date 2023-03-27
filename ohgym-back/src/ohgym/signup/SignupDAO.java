package ohgym.signup;

import java.sql.Connection;

public interface SignupDAO {
	//회원가입 정보 DB 추가
	public int insertUser(SignupUser user);
	
	//아이디 중복체크
	public boolean isDuplicatedId(String userId);
}
