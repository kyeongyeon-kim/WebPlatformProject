package ohgym.teacher;

import java.util.List;


public interface TeacherDAO {
	// TeacherProfile 정보 가져오기
	List<TeacherProfile> readTeacherProfile();

	// TeacherProfile 정보 가져오기(아이디검색)
	List<TeacherProfile> readTeacherProfileById(String id);
	
	// TeacherProfile 정보 가져오기(user가 찜한 선생님)
	List<TeacherProfile> readTeacherProfileByUserPick(String userId);

	// TeacherProfile 정보 업데이트
	int updateTeacherProfile(TeacherProfile profile);
	
	// etc
	String convertExerciseTypeToExercise(String exerciseType);
	String convertExerciseToExerciseType(String exercise);
}
