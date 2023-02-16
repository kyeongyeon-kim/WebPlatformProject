package ohgym.teacher;

public class TeacherExercise {
	private String id;
	private String exercise_type;
	private String location;
	private String career;
	private String introduction;
	public TeacherExercise(String id, String exercise_type, String location, String career, String introduction) {
		super();
		this.id = id;
		this.exercise_type = exercise_type;
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
		return "TeacherService [id=" + id + ", exercise_type=" + exercise_type + ", location=" + location + ", career="
				+ career + ", introduction=" + introduction + "]";
	}
}
