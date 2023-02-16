package ohgym.teacher;

import java.util.List;

public interface TeacherService {
	// teacher_introduction
	TeacherInfo createTeacherInfo(TeacherInfo info);
	List<TeacherInfo> readTeacherInfo();
	TeacherInfo updateTeacherInfo(TeacherInfo info);
	TeacherInfo deleteTeacherInfo(String id);
	
	// teacher_exercise 
	String createExercise(String id, String type);
	String updateExercise(String id, String type);
	String deleteExercise(String id, String type);
	
	// teacher_service
	TeacherExercise createTeacherExercise(TeacherExercise exercise);
	List<TeacherExercise> readTeacherExercise();
	TeacherExercise updateTeacherExercise(TeacherExercise exercise);
	TeacherExercise deleteTeacherExercise(String id, String type);
	
	// teacher_profile
	TeacherProfile readTeacherProfile(String id);
	
	// teacher_image
	
}
