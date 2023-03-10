package ohgym.userrequest;

import java.util.List;

public interface RequestInfoService {
	List<RequestInfo> selectRequestInfo(String user_id);
	List<RequestInfo> selectRequestInfoNoAll();
}
