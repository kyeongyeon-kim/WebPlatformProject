
import java.util.ArrayList;
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
		public void filterTest() {
			String str = "부산 부산진구 중앙대로 749 혜도빌딩 4층 그린컴퓨터아카데미";
			RequestService service = new RequestServiceImpl(new RequestDAOImpl());
			
			List<Request> reqList = service.selectRequest();
			// 사용자 > 고수 (견적서 ALL)
			RequestInfoDAO dao = new RequestInfoDAO();
			List<RequestInfo> list = dao.requestInfoList("경연");
			for (RequestInfo requestInfo : list) {
				System.out.println(requestInfo);
			}
			
			for (Request request : reqList) {
				System.out.println(request);
			}
			
			for (RequestInfo requestInfo : list) {
				if(requestInfo.getAnswer7().equals(str.substring(0, 2))) {
					System.out.println(requestInfo.getUser_id());
				}
			}
//			List<Request> requestList = service.selectRequestById();
//			System.out.println(requestList);
		}
}
