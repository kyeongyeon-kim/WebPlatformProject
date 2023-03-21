package ohgym.teacher;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class TeacherController {
	private static final Logger logger = LoggerFactory.getLogger(TeacherController.class);

	@Autowired
	private TeacherService service;
	
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
	
	@GetMapping("/find")
	public String findget(@RequestParam(name = "area", required = false) String area,
			@RequestParam(name = "search", required = false) String search, Model model) {
		if (area != null) {
			model.addAttribute("area", area);
		}
		if (search != null) {
			model.addAttribute("inputText", search);
		}
		model.addAttribute("list", service.readAllTeacherProfile());
		return "find";
	}

	@PostMapping("/find")
	public String findpost(@RequestParam(name = "area", required = false) String area,
			@RequestParam(name = "search", required = false) String search, Model model) {
		if (area != null) {
			model.addAttribute("area", area);
		}
		if (search != null) {
			model.addAttribute("inputText", search);
		}
		model.addAttribute("list", service.readAllTeacherProfile());
		return "find";
	}
	
	@GetMapping("/profileId")
	public String profileId(@RequestParam(name = "id") String id, Model model) {
		model.addAttribute("profileById", service.readTeacherProfile(id));
		return "teacherProfile";
	}
	
	@GetMapping("/teacherPick")
	@ResponseBody
	public List<TeacherProfile> teacherPick() {
	    String id = "도연"; // 이거확인!!!!!!!!!!!!
	    List<TeacherProfile> list = service.readUserPickTeacherProfile(id);
	    return list;
	}
}











