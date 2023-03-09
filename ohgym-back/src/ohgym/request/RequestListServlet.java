package ohgym.request;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import ohgym.teacher.TeacherProfile;
import ohgym.userrequest.RequestInfo;
import ohgym.userrequest.RequestInfoDAO;

@WebServlet("/requestList")
public class RequestListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestService service = new RequestServiceImpl(new RequestDAOImpl());
		RequestInfoDAO dao = new RequestInfoDAO();
		List<Request> FilteredtList = new ArrayList<>();
		TeacherProfile teacherProfile = new TeacherProfile("경연"
				, "'김경태 고수의 퍼스널트레이닝(PT) 한번배워 평생 운동합시다! 방문피티도 가능합니다. 현장피티는 스포애니강남역2호점에서 진행합니다'"
				, "09:00-18:00", "클라이밍", "김경연 퍼스널트레이닝"
				, "오짐2호점", "부산 부산진구 중앙대로 749 혜도빌딩 4층 그린컴퓨터아카데미"
				, "2년", "https://i.postimg.cc/G2JD4kg1/health.png");
		
		List<Request> requestList = service.selectRequest();
		for (Request request : requestList) {
			for (RequestInfo requestInfo : dao.requestInfoList(request.getId())) {
				if(isValidRequest(request, requestInfo, teacherProfile)) {
					FilteredtList.add(request);
				}
			}
		}
		
		req.setAttribute("list", FilteredtList);
		req.getRequestDispatcher("/views/mypageTeacher.jsp").forward(req, resp);

	}

	private boolean isValidRequest(Request request, RequestInfo requestInfo, TeacherProfile teacherProfile) {
		Calendar cal = Calendar.getInstance();
		cal.set(2023, 1, 22);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			if(requestInfo.getAnswer7() != null
					&& dateFormat.parse(requestInfo.getRequest_date()).compareTo(cal.getTime()) <= 0
					&& dateFormat.parse(requestInfo.getDeadline_date()).compareTo(cal.getTime()) >= 0
					&& request.getExerciseType().equals(teacherProfile.getExercise())
					&& requestInfo.getAnswer7().equals(teacherProfile.getLocation().substring(0, 2))) {
				return true;
			}
		} catch (ParseException e) {
			throw new RuntimeException(e);
		} 
		return false;
	}
}
