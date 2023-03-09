package ohgym.userrequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import ohgym.dbutil.ConnectionProvider;
import ohgym.request.RequestDAOImpl;
import ohgym.request.RequestService;
import ohgym.request.RequestServiceImpl;

@WebServlet("/requestfind")
public class RequestInfoServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BufferedReader reader = req.getReader();
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			sb.append(line);
		}
		String user_id = sb.toString();
		
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