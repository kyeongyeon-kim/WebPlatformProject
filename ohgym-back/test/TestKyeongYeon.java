
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import ohgym.login.LoginService;
import ohgym.request.Request;
import ohgym.request.RequestDAOImpl;
import ohgym.request.RequestService;
import ohgym.request.RequestServiceImpl;
import ohgym.userrequest.RequestInfo;
import ohgym.userrequest.RequestInfoDAO;
import ohgym.userrequest.RequestInfoDAOImpl;
import ohgym.userrequest.RequestInfoService;
import ohgym.userrequest.RequestInfoServiceImpl;


public class TestKyeongYeon {
		@Autowired
		private LoginService loginService;
		@Autowired
		private JdbcTemplate jdbcTemplate;
		// 견적서 필터링 테스트
		@Test
		public void filterTest() throws ParseException {
			Calendar cal = Calendar.getInstance();
			cal.set(2023, 1, 22);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String str = "부산 부산진구 중앙대로 749 혜도빌딩 4층 그린컴퓨터아카데미";
			RequestService service = new RequestServiceImpl(new RequestDAOImpl());
			
			RequestInfoService infoService = new RequestInfoServiceImpl(new RequestInfoDAOImpl());
			
			List<Request> afterFilterList = new ArrayList<>();
			List<Request> reqList = service.selectRequest();
			
			for (int i = 0; i < reqList.size(); i++) {
				for (RequestInfo requestInfo : infoService.selectRequestInfo(reqList.get(i).getId())) {
					
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
		}
		@Test
		public void login() {
			int result = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM user WHERE id = ? AND pw = ?", Integer.class);
			System.out.println(result);
		}
}
