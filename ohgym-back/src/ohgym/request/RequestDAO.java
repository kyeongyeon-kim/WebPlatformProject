package ohgym.request;

import java.util.List;

public interface RequestDAO {
	// (R) selectRequest
	List<Request> selectRequest();
	List<Request> selectRequestById(String id);
	Request selectRequestByNo(int no);
}
