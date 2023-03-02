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

@WebServlet("/requestfind")
public class RequestInfoServlet extends HttpServlet {
	List<RequestInfo> reqInfoList;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BufferedReader reader = req.getReader();
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			sb.append(line);
		}
		String user_id = sb.toString();
		
		RequestInfoDAO reqInfoDAO = new RequestInfoDAO();
		reqInfoList = new ArrayList<>();
		reqInfoList = reqInfoDAO.requestInfoList(user_id);
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(reqInfoList);
		System.out.println(json);
		PrintWriter pw = resp.getWriter();
		pw.println(json);
		pw.flush();
		
	}
}