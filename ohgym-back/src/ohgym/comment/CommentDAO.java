package ohgym.comment;

import java.sql.Connection;
import java.util.List;

public interface CommentDAO {
	int commentInsert(CommentInfo commentInfo);
	List<CommentInfo> userComment(String user_id);
	List<CommentInfo> teacherComment(String teacher_id);
	List<CommentInfo> allComment();
}