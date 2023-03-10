package ohgym.userrequest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/requestfind")
public class RequestInfoServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String user_id = (String) session.getAttribute("id");
		
		RequestInfoService service = new RequestInfoServiceImpl(new RequestInfoDAOImpl());

		// 특정 유저의 요청서  
		List<RequestInfo> reqInfoList = service.selectRequestInfo(user_id);
		// 전체 유저의 요청서  
//		List<RequestInfo> reqInfoList = service.selectRequestInfoNoAll();
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(reqInfoList);
		
		// 콘솔에서 json 형태로 체크(한 줄) 
		System.out.println(json);
		
		PrintWriter pw = resp.getWriter();
		pw.println(json);
		pw.flush();
		
	}
}