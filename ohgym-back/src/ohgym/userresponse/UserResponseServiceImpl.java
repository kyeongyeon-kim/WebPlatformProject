package ohgym.userresponse;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserResponseServiceImpl implements UserResponseService {
	private UserResponseDAO dao;
	
	public UserResponseServiceImpl(UserResponseDAO dao) {
		super();
		this.dao = dao;
	}
	
	@Override
	public List<String> responseList(String str) {
		return dao.responseList(str);
	}
}