package ohgym.teacher;

import java.util.List;

public interface TeacherService {
	// teacher_introduction
	TeacherInfo createTeacherInfo(TeacherInfo info);
	List<TeacherInfo> readTeacherInfo();
	TeacherInfo updateTeacherInfo(TeacherInfo info);
	TeacherInfo deleteTeacherInfo(String id);
	
	// teacher_service
	// teacher_image
}
