package ohgym.request;

import java.util.List;

public interface RequestService {
	List<Request> selectRequest();
	List<Request> selectRequestById(String id);
}
