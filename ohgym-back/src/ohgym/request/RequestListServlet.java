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
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import ohgym.teacher.TeacherDAOImpl;
import ohgym.teacher.TeacherProfile;
import ohgym.teacher.TeacherService;
import ohgym.teacher.TeacherServiceImpl;
import ohgym.userrequest.RequestInfo;
import ohgym.userrequest.RequestInfoDAO;
import ohgym.userrequest.RequestInfoDAOImpl;
import ohgym.userrequest.RequestInfoService;
import ohgym.userrequest.RequestInfoServiceImpl;

@WebServlet("/requestList")
public class RequestListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestService service = new RequestServiceImpl(new RequestDAOImpl());
		TeacherService teacherService = new TeacherServiceImpl(new TeacherDAOImpl());
//		RequestInfoDAO dao = new RequestInfoDAO();
		RequestInfoService infoService = new RequestInfoServiceImpl(new RequestInfoDAOImpl());
		List<Request> FilteredtList = new ArrayList<>();
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("id");
		List<TeacherProfile> teacherProfile = teacherService.readTeacherProfile(id);
		
		System.out.println("머야이건"+teacherProfile);
		List<Request> requestList = service.selectRequest();
		for (Request request : requestList) {
			for (RequestInfo requestInfo : infoService.selectRequestInfo(request.getId())) {
				if(isValidRequest(request, requestInfo, teacherProfile.get(0))) {
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
