package ohgym.teacher;

import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class TeacherServiceImpl implements TeacherService {
	private TeacherDAO dao;

	public TeacherServiceImpl(TeacherDAO dao) {
		super();
		this.dao = dao;
	}

	// TeacherProfileRead
	@Override
	public List<TeacherProfile> readTeacherProfile(String id) {
		return dao.readTeacherProfileById(id);
	}

	@Override
	public List<TeacherProfile> readAllTeacherProfile() {
		return dao.readTeacherProfile();
	}
	
	@Override
	public List<TeacherProfile> readUserPickTeacherProfile(String id) {
		return dao.readTeacherProfileByUserPick(id);
	}
	
	// updateTeacherProfile
	@Override
	public int updateTeacherProfile(TeacherProfile teacherProfile) {
		return dao.updateTeacherProfile(teacherProfile);
	}

	@Override
	public String convertExerciseTypeToExercise(String exerciseType) {
		return dao.convertExerciseTypeToExercise(exerciseType);
	}

	@Override
	public String convertExerciseToExerciseType(String exercise) {
		return dao.convertExerciseToExerciseType(exercise);
	}	
}
