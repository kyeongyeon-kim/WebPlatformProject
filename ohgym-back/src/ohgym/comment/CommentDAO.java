package ohgym.comment;

import java.sql.Connection;
import java.util.List;

public interface CommentDAO {
	int commentInsert(Connection conn, CommentInfo commentInfo);
	List<CommentInfo> userComment(Connection conn, String user_id);
	List<CommentInfo> teacherComment(Connection conn, String teacher_id);
	List<CommentInfo> allComment(Connection conn);
}