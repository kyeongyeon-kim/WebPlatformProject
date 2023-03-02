
import java.util.List;

import org.junit.Test;

import ohgym.userrequest.RequestInfo;
import ohgym.userrequest.RequestInfoDAO;


public class TestKyeongYeon {
		@Test
		public void filterTest() {
			RequestInfoDAO dao = new RequestInfoDAO();
			List<RequestInfo> list = dao.requestInfoList("경연");
			System.out.println(list);
		}
}
