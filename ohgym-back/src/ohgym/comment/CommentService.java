package ohgym.comment;

import java.util.List;

public interface CommentService {
	int commentInsert(CommentInfo commentInfo);
	List<CommentInfo> userComment(String user_id);
	List<CommentInfo> teacherComment(String teacher_id);
	List<CommentInfo> allComment();
}
