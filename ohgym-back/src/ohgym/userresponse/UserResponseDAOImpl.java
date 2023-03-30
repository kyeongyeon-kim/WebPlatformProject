package ohgym.userresponse;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserResponseDAOImpl implements UserResponseDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<String> rowMapper = new RowMapper<String>() {
		@Override
		public String mapRow(ResultSet rs, int rowNum) throws SQLException {
			List<String> list = new ArrayList<>();
			list.add(rs.getString("categoryName"));
			list.add(rs.getString("requestNum"));
			list.add(rs.getString("scoreNum"));
			list.add(rs.getString("reviewNum"));
			list.add(rs.getString("activeNum"));
			return String.join(", ", list);
		}
	};
	
	@Override
	public List<String> responseList(String str){
		String sql = "SELECT exercise_type.exercise AS categoryName, " 
		+ "(SELECT avg(score)FROM ohgym.comment WHERE ohgym.comment.teacher_id IN "
			+ "(SELECT teacher_exercise.id FROM teacher_exercise WHERE exercise_type = " + str + "))  AS scoreNum, " 
		+ "(SELECT count(*) FROM request WHERE request.exercise_type = " + str + ") AS requestNum, "
		+ "(SELECT count(*) FROM teacher_exercise WHERE teacher_exercise.exercise_type = " + str + ") AS activeNum, " 
		+ "(SELECT count(*) FROM ohgym.comment WHERE ohgym.comment.teacher_id IN "
			+ "(SELECT teacher_exercise.id FROM teacher_exercise WHERE exercise_type = " + str + ")) AS reviewNum " 
		+ "FROM exercise_type WHERE exercise_type.no = " + str;
		return jdbcTemplate.query(sql, rowMapper);
	}
}