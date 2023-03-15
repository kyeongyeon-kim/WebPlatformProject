package ohgym.request;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class RequestDAOImpl implements RequestDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private RowMapper<Request> rowMapper = new BeanPropertyRowMapper<Request>(Request.class);
	
	@Override
	public List<Request> selectRequest() {
		return jdbcTemplate.query("select * from request as A left outer join exercise_type as B on A.exercise_type = B.no;"
				, rowMapper);
	}
	
	@Override
	public List<Request> selectRequestById(String id) {
		return jdbcTemplate.query("select * from request as A"
				+ " left outer join exercise_type as B"
				+ " on A.exercise_type = B.no WHERE user_id = ?", rowMapper, id);
	}
	
	@Override
	public Request selectRequestByNo(int no) {
		return jdbcTemplate.queryForObject("select * from request as A"
				+ " left outer join exercise_type as B on A.exercise_type = B.no"
				+ " WHERE request_no = ?", rowMapper, no);
	}
}
