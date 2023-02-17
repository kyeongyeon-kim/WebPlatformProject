
package ohgym.teacher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;


@WebServlet("/profile")
public class TeacherProfileServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		
		TeacherService service = new TeacherServiceImpl(new TeacherDAOImpl());
		
		
		TeacherProfile teacherprofile = new TeacherProfile("경태", "경태의 PT세계로 컴온", "09:00-18:00", "퍼스널 트레이닝", "김경태 퍼스널트레이닝", "스포애니 강남역2호점", "부산 부산진구 부전로4", "5년 6개월","");
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(teacherprofile); 
		PrintWriter pw = resp.getWriter();
		pw.println(json);
		pw.flush();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BufferedReader reader = req.getReader(); // 요청 데이터를 읽어옵니다.
	    StringBuilder sb = new StringBuilder();
	    String line;
	    while ((line = reader.readLine()) != null) {
	        sb.append(line);
	    }
	    ObjectMapper mapper = new ObjectMapper();
	    
	    String strProfile = sb.toString();
	    TeacherProfile teacherProfile = mapper.readValue(strProfile, TeacherProfile.class);
	    
	    System.out.println(teacherProfile);
	}
}
