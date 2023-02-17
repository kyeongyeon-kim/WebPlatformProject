package ohgym.teacher;

public class TeacherExercise {
	private String id;
	private String exercise_type;
	private String center_name;
	private String location;
	private String career;
	private String introduction;
	public TeacherExercise(String id, String exercise_type, String center_name, String location, String career,
			String introduction) {
		super();
		this.id = id;
		this.exercise_type = exercise_type;
		this.center_name = center_name;
		this.location = location;
		this.career = career;
		this.introduction = introduction;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getExercise_type() {
		return exercise_type;
	}
	public void setExercise_type(String exercise_type) {
		this.exercise_type = exercise_type;
	}
	public String getCenter_name() {
		return center_name;
	}
	public void setCenter_name(String center_name) {
		this.center_name = center_name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCareer() {
		return career;
	}
	public void setCareer(String career) {
		this.career = career;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	@Override
	public String toString() {
		return "TeacherExercise [id=" + id + ", exercise_type=" + exercise_type + ", center_name=" + center_name
				+ ", location=" + location + ", career=" + career + ", introduction=" + introduction + "]";
	}
	
	
	
}
