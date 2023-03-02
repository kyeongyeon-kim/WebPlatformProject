import java.util.List;

import org.junit.Test;

import ohgym.request.Request;
import ohgym.request.RequestDAOImpl;
import ohgym.request.RequestService;
import ohgym.request.RequestServiceImpl;

public class TestKyeongYeon {
		@Test
		public void filterTest() {
			String str = "부산 부산진구 중앙대로 749 혜도빌딩 4층 그린컴퓨터아카데미";
			RequestService service = new RequestServiceImpl(new RequestDAOImpl());
			List<Request> list = service.selectRequest();
			System.out.println(str.substring(0, 2));
			for (Request request : list) {
				if (str.substring(0, 2).equals("부산")) {
					System.out.println("true");
				}
			}
		}
}
