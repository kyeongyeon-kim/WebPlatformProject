package ohgym.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository
public class CommentDAOImpl implements CommentDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private RowMapper<CommentInfo> rowMapper = new BeanPropertyRowMapper<CommentInfo>(CommentInfo.class);
	
	public int commentInsert(CommentInfo commentInfo) {
		String sql = "INSERT INTO ohgym.comment (user_id, teacher_id, score, review) VALUES (?, ?, ?, ?)";
		return jdbcTemplate.update(sql, commentInfo.getUser_id()
				, commentInfo.getTeacher_id()
				, commentInfo.getScore()
				, commentInfo.getReview());
	}

	public List<CommentInfo> userComment(String user_id) {
		String sql = "SELECT * FROM comment WHERE user_id = ?";
		return jdbcTemplate.query(sql, rowMapper, user_id); 
	}

	public List<CommentInfo> teacherComment(String teacher_id) {
		String sql = "SELECT * FROM comment WHERE teacher_id = ?";
		return jdbcTemplate.query(sql, rowMapper, teacher_id); 
	}

	public List<CommentInfo> allComment() {
		String sql = "SELECT * FROM comment";
		return jdbcTemplate.query(sql, rowMapper);
	}
}
