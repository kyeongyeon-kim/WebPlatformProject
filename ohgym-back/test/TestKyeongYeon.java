
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import ohgym.request.Request;
import ohgym.request.RequestDAOImpl;
import ohgym.request.RequestService;
import ohgym.request.RequestServiceImpl;
import ohgym.userrequest.RequestInfo;
import ohgym.userrequest.RequestInfoDAO;


public class TestKyeongYeon {
		@Test
		public void filterTest() throws ParseException {
			Calendar cal = Calendar.getInstance();
			cal.set(2023, 1, 22);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String str = "부산 부산진구 중앙대로 749 혜도빌딩 4층 그린컴퓨터아카데미";
			RequestService service = new RequestServiceImpl(new RequestDAOImpl());
			
			RequestInfoDAO dao = new RequestInfoDAO();
			
			List<Request> afterFilterList = new ArrayList<>();
			List<Request> reqList = service.selectRequest();
			
			for (int i = 0; i < reqList.size(); i++) {
				for (RequestInfo requestInfo : dao.requestInfoList(reqList.get(i).getId())) {
					
					if(requestInfo.getAnswer7() != null
							&& dateFormat.parse(requestInfo.getRequest_date()).compareTo(cal.getTime()) <= 0
							&& dateFormat.parse(requestInfo.getDeadline_date()).compareTo(cal.getTime()) >= 0
							&& reqList.get(i).getExerciseType().equals("퍼스널트레이닝")
							&& requestInfo.getAnswer7().equals(str.substring(0, 2))) {
						afterFilterList.add(reqList.get(i));
					} 
				}
			}
			
			for (Request request : afterFilterList) {
				System.out.println(request);
			}
			
//			for (RequestInfo requestInfo : list) {
//				if(requestInfo.getAnswer7() != null && requestInfo.getAnswer7().equals(str.substring(0, 2))) {
//					System.out.println(requestInfo.getUser_id());
//				}
//			}
//			List<Request> requestList = service.selectRequestById();
//			System.out.println(requestList);
		}
}
