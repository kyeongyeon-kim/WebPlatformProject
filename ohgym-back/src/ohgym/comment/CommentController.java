package ohgym.comment;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class CommentController {
	@Autowired
	private CommentService service;
	
	@PostMapping("commentfind")
	@ResponseBody
	public String commentFind(HttpSession session) throws JsonProcessingException {
		String user_id = (String) session.getAttribute("id");
		List<CommentInfo> commentInfoList = new ArrayList<>();
		commentInfoList = service.userComment(user_id);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(commentInfoList);
		return json;
	}
	
	@PostMapping("/commentrequest")
	public ResponseEntity<String> commentRequest(@RequestBody CommentInfo commentInfo) {
		service.commentInsert(commentInfo);
		return ResponseEntity.ok("OK");
	}
}
