package ohgym.suggest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class suggestController {
	@Autowired
	SuggestService suggestService;
	
	@PostMapping("/sendSuggest")
	public String sendSuggest(@RequestBody Suggest suggest) {
		suggestService.insertSuggest(suggest);
		return "requestList";
	}
	
	@GetMapping("/suggestGo")
	public ModelAndView suggestGoGet(ModelAndView mv) {
		List<Suggest> list = suggestService.selectSuggest();
		
		mv.addObject("suggestGo",list);
		mv.setViewName("detailRequest");
		return mv ;
	}
	
	@GetMapping("/suggestTeacherInfo")
	public List<Suggest> suggestTeacher(ModelAndView mv) {
		List<Suggest> list = suggestService.selectSuggest();
		
		return list;
		
	}
	
}
