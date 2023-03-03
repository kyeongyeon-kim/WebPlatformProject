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

import ohgym.userrequest.RequestInfo;
import ohgym.userrequest.RequestInfoDAO;

@WebServlet("/requestList")
public class RequestListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestService service = new RequestServiceImpl(new RequestDAOImpl());
		RequestInfoDAO dao = new RequestInfoDAO();
		List<Request> FilteredtList = new ArrayList<>();
		
		List<Request> requestList = service.selectRequest();
		for (Request request : requestList) {
			for (RequestInfo requestInfo : dao.requestInfoList(request.getId())) {
				if(isValidRequest(request, requestInfo)) {
					FilteredtList.add(request);
				}
			}
		}

		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(FilteredtList);
		System.out.println(json);
		PrintWriter pw = resp.getWriter();
		pw.println(json);
		pw.flush();
	}

	private boolean isValidRequest(Request request, RequestInfo requestInfo) {
		String str = "부산 부산진구 중앙대로 749 혜도빌딩 4층 그린컴퓨터아카데미";
		Calendar cal = Calendar.getInstance();
		cal.set(2023, 1, 22);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			if(requestInfo.getAnswer7() != null
					&& dateFormat.parse(requestInfo.getRequest_date()).compareTo(cal.getTime()) <= 0
					&& dateFormat.parse(requestInfo.getDeadline_date()).compareTo(cal.getTime()) >= 0
					&& request.getExerciseType().equals("퍼스널트레이닝")
					&& requestInfo.getAnswer7().equals(str.substring(0, 2))) {
				return true;
			}
		} catch (ParseException e) {
			throw new RuntimeException(e);
		} 
		return false;
	}
}
