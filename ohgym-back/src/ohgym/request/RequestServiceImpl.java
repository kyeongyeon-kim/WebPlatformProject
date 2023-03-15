package ohgym.request;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ohgym.teacher.TeacherProfile;
import ohgym.userrequest.RequestInfo;

@Service
public class RequestServiceImpl implements RequestService {
	@Autowired
	private RequestDAO dao;

	@Override
	public List<Request> selectRequest() {
		return dao.selectRequest();
	}

	@Override
	public List<Request> selectRequestById(String id) {
		return dao.selectRequestById(id);
	}

	@Override
	public Request selectRequestByNo(int no) {
		return dao.selectRequestByNo(no);
	}

	@Override
	public boolean isValidRequest(Request request, RequestInfo requestInfo, TeacherProfile teacherProfile) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			if(requestInfo.getAnswer7() != null
					&& dateFormat.parse(requestInfo.getRequest_date()).compareTo(cal.getTime()) <= 0
					&& dateFormat.parse(requestInfo.getDeadline_date()).compareTo(cal.getTime()) >= 0
					&& request.getExerciseType().equals(teacherProfile.getExercise())
					&& (requestInfo.getAnswer7().substring(0, 2)).equals(teacherProfile.getLocation().substring(0, 2))
					&& request.getId() != teacherProfile.getId()) {
				return true;
			}
		} catch (ParseException e) {
			throw new RuntimeException(e);
		} 
		return false;
	}
}
