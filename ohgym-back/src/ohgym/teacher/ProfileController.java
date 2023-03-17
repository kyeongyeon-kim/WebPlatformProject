package ohgym.teacher;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfileController {
	@Autowired
	TeacherService service;
	
	@GetMapping("/profile")
	public ModelAndView profile(ModelAndView mv, HttpSession session) {
		String id = (String) session.getAttribute("id");
		List<TeacherProfile> teacherprofile = service.readTeacherProfile(id);
		mv.addObject("profile", teacherprofile.get(0));
		return mv;
	}
	
	@PostMapping("/profile")
	public ResponseEntity<String> profile(@RequestBody TeacherProfile teacherProfile) {
		String exerciseType = service.convertExerciseToExerciseType(teacherProfile.getExercise());
		teacherProfile.setExercise(exerciseType);
		service.updateTeacherProfile(teacherProfile);
		return ResponseEntity.ok("OK");
	}
}
