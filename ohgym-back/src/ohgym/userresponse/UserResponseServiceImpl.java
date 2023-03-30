package ohgym.userresponse;

import java.util.List;

<<<<<<< HEAD
=======
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> 7523e6bd2897de66ac9b529820d97ca8617d1410
import org.springframework.stereotype.Service;

@Service
public class UserResponseServiceImpl implements UserResponseService {
	@Autowired
	private UserResponseDAO dao;
	
<<<<<<< HEAD
	public UserResponseServiceImpl(UserResponseDAO dao) {
		super();
		this.dao = dao;
	}
	
	@Override
	public List<String> responseList(String str) {
		return dao.responseList(str);
=======
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
		
>>>>>>> 7523e6bd2897de66ac9b529820d97ca8617d1410
	}
}