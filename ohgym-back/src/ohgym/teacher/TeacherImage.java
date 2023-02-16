package ohgym.teacher;

import java.awt.Image;

public class TeacherImage {
	private String id;
	private Image image;
	public TeacherImage(String id, Image image) {
		super();
		this.id = id;
		this.image = image;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "TeacherImage [id=" + id + ", image=" + image + "]";
	}
}
