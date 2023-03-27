package ohgym.userresponse;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserResponseServiceImpl implements UserResponseService {
	@Autowired
	private UserResponseDAO dao;
	
	@Override
	public String categoryName(String str) {
		return dao.categoryName(str);
	}
	
	@Override
	public String scoreNum(String str) {
			return dao.scoreNum(str);
	}
	
	@Override
	public String requestNum(String str) {
			return dao.requestNum(str);
	}
	
	@Override
	public String activeNum(String str) {
			return dao.activeNum(str);
	}
	
	@Override
	public String reviewNum(String str) {
			return dao.reviewNum(str);
		
	}
}