package ohgym.request;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ohgym.teacher.TeacherProfile;
import ohgym.teacher.TeacherService;
import ohgym.userrequest.RequestInfo;
import ohgym.userrequest.RequestInfoService;

@Controller
public class RequestController {
	@Autowired
	RequestService requestService;
	@Autowired
	TeacherService teacherService;
	@Autowired
	RequestInfoService infoService;
	
	
	@GetMapping("/requestList")
	public ModelAndView requestList(ModelAndView mv, HttpSession session) {
		List<Request> FilteredtList = new ArrayList<>();
		String id = (String) session.getAttribute("id");
		List<TeacherProfile> teacherProfile = teacherService.readTeacherProfile(id);
		List<Request> requestList = requestService.selectRequest();
		for (Request request : requestList) {
			for (RequestInfo requestInfo : infoService.selectRequestInfo(request.getId())) {
				if(requestService.isValidRequest(request, requestInfo, teacherProfile.get(0))) {
					FilteredtList.add(request);
				}
			}
		}
		mv.addObject("list", FilteredtList);
		mv.setViewName("mypageTeacher");
		return mv;
	}
	
	@GetMapping("/requestNo")
	public String requestNoGet(@RequestParam("no") int no, Model model) {
		Request request = requestService.selectRequestByNo(no);
		RequestInfo requestInfo = infoService.selectRequestInfoByNo(no);
		model.addAttribute("request",request);
		model.addAttribute("requestinfo",requestInfo);
		return "suggest";
	}
	
	@GetMapping("/clientRequest")
	public String requestListclientGet(HttpSession session,Model model) {
		String id = (String) session.getAttribute("id");
		List<Request> list = requestService.selectRequestById(id);
		model.addAttribute("requestList",list);
		return "mypageClient";
	}
}
