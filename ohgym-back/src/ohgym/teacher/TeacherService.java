package ohgym.teacher;

import java.util.List;

public interface TeacherService {
	// (R)teacher_profile
	List<TeacherProfile> readTeacherProfile(String id);
	List<TeacherProfile> readAllTeacherProfile();
	
	
	
}
