package ohgym.teacher;

import java.sql.Connection;
import java.util.List;


public interface TeacherDAO {
	// TeacherProfile 정보 가져오기
	List<TeacherProfile> readTeacherProfile(Connection conn);
	
	// TeacherProfile 정보 가져오기(지역별)
	List<TeacherProfile> readTeacherProfileByLocation(Connection conn, String location);
	
	// TeacherProfile 정보 가져오기(종목별)
	List<TeacherProfile> readTeacherProfileByType(Connection conn, String type);
	
	// TeacherProfile 정보 가져오기(아이디검색)
	List<TeacherProfile> readTeacherProfileById(Connection conn, String id);
	
	// TeacherProfile 정보 등록
	int insertTeacherProfile(Connection conn, TeacherProfile profile);
	
	// TeacherProfile 정보 업데이트
	int updateTeacherProfile(Connection conn, TeacherProfile profile);
	
	// TeacherProfile 삭제하기
	int deleteTeacherProfile(Connection conn, String id, String type);
	
	// etc
	String convertExerciseTypeToExercise(Connection conn, String exerciseType);
	String convertExerciseToExerciseType(Connection conn, String exercise);
}
