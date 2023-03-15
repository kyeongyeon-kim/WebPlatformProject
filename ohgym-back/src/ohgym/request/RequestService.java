package ohgym.request;

import java.util.List;

import ohgym.teacher.TeacherProfile;
import ohgym.userrequest.RequestInfo;

public interface RequestService {
	List<Request> selectRequest();
	List<Request> selectRequestById(String id);
	Request selectRequestByNo(int no);
	
	// 필터링메소드
	boolean isValidRequest(Request request, RequestInfo requestInfo, TeacherProfile teacherProfile);
}
