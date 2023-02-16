package ohgym.teacher;

import java.awt.Image;
import java.sql.Connection;
import java.util.List;


public interface TeacherDAO {
	// teacher_introduction
	int insertIntroduction(Connection conn, TeacherInfo info);
	List<TeacherInfo> selectInfo(Connection conn);	
	TeacherInfo selectInfoById(Connection conn, String id);
	int updateInfo(Connection conn, TeacherInfo info);
	int deleteInfo(Connection conn, String id);
	
	// teacher_exercise 
	int insertExercise(Connection conn, String type);
	
	// teacher_service
	int insertExerciseInfo(Connection conn, TeacherExercise exercise);
	List<TeacherExercise> selectService(Connection conn);
	TeacherExercise selectServiceById(Connection conn, String id);
	TeacherExercise selectServiceByType(Connection conn, String type);
	int updateService(Connection conn, TeacherExercise exercise);
	int deleteService(Connection conn, TeacherExercise exercise);
	
	// teacher_image
	int insertImage(Connection conn, TeacherImage image);
	Image selectImageById(Connection conn, String id);
	int updateImage(Connection conn, Image image);
	int deleteImage(Connection conn, String id);
	int insertService(Connection conn, TeacherExercise service);
	
}
