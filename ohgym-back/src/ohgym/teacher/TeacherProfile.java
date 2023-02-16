package ohgym.teacher;

public class TeacherProfile {
	private String id;
	private String name;
	private String exerciseType;
	private String introduction;
	private String location;
	private String employees;
	private String career;
	
	public TeacherProfile() {};
	
	public TeacherProfile(String id, String name, String exerciseType, String introduction, String location, String employees,
			String career) {
		super();
		this.id = id;
		this.name = name;
		this.exerciseType = exerciseType;
		this.introduction = introduction;
		this.location = location;
		this.employees = employees;
		this.career = career;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getExerciseType() {
		return exerciseType;
	}
	public void setExerciseType(String exerciseType) {
		this.exerciseType = exerciseType;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getEmployees() {
		return employees;
	}
	public void setEmployees(String employees) {
		this.employees = employees;
	}
	public String getCareer() {
		return career;
	}
	public void setCareer(String career) {
		this.career = career;
	}
	
	
}
