package ohgym.comment;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentDAO dao;

	@Override
	public int commentInsert(CommentInfo commentInfo) {
		return dao.commentInsert(commentInfo);
	}

	@Override
	public List<CommentInfo> userComment(String user_id) {
		return dao.userComment(user_id);
	}

	@Override
	public List<CommentInfo> teacherComment(String teacher_id) {
		return dao.teacherComment(teacher_id);
	}

	@Override
	public List<CommentInfo> allComment() {
			return dao.allComment();
	}
}
