package ohgym.userrequest;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RequestInfoServiceImpl implements RequestInfoService {
	@Autowired
	private RequestInfoDAO dao;
	
	@Override
	public List<RequestInfo> selectRequestInfo(String user_id) {
			return dao.selectRequestInfo(user_id);	
	}
	
	@Override
	public List<RequestInfo> selectRequestInfoNoAll() {
			return dao.selectRequestInfoNoAll();
	}
	
	@Override
	public RequestInfo selectRequestInfoByNo(int no) {
			return dao.selectRequestInfoByNo(no);	
	}
}
