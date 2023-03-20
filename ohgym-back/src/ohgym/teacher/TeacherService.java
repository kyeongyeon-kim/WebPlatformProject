package ohgym.teacher;

import java.util.List;

public interface TeacherService {
	// (R)teacher_profile
	List<TeacherProfile> readTeacherProfile(String id);
	List<TeacherProfile> readAllTeacherProfile();
	List<TeacherProfile> readUserPickTeacherProfile(String id);
	// (U)teacher_profile
	int updateTeacherProfile(TeacherProfile teacherProfile);
	
	// etc
	String convertExerciseTypeToExercise(String exerciseType);
	String convertExerciseToExerciseType(String exercise);	
}
