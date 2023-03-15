package ohgym.request;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import ohgym.teacher.TeacherProfile;
import ohgym.teacher.TeacherService;
import ohgym.userrequest.RequestInfo;
import ohgym.userrequest.RequestInfoService;

@Controller
public class RequestListController {
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
}
