package ohgym.suggest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class suggestController {
	@Autowired
	SuggestService suggestService;
	
	@PostMapping("/sendSuggest")
	public String sendSuggest(@RequestBody Suggest suggest) {
		suggestService.insertSuggest(suggest);
		return "requestList";
	}
}
