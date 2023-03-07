
package ohgym.teacher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import ohgym.request.Request;

@WebServlet("/profile")
public class TeacherProfileServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TeacherService service = new TeacherServiceImpl(new TeacherDAOImpl());
		String id = "경연";
		
		List<TeacherProfile> teacherprofile = service.readTeacherProfile(id);
		req.setAttribute("profile", teacherprofile.get(0));
		req.getRequestDispatcher("/views/profile.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BufferedReader reader = req.getReader();
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			sb.append(line);
		}
		ObjectMapper mapper = new ObjectMapper();
		String strProfile = sb.toString();
		TeacherProfile teacherProfile = mapper.readValue(strProfile, TeacherProfile.class);
		
		TeacherService service = new TeacherServiceImpl(new TeacherDAOImpl());
		String exerciseType = service.convertExerciseToExerciseType(teacherProfile.getExercise());
		teacherProfile.setExercise(exerciseType);
		service.updateTeacherProfile(teacherProfile);
	}
}
