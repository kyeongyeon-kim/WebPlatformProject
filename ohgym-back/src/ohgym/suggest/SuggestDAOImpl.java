package ohgym.suggest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class SuggestDAOImpl implements SuggestDAO {
	@Autowired
	private JdbcTemplate jdbctemplate;
	private RowMapper<Suggest> rowMapper = new BeanPropertyRowMapper<Suggest>(Suggest.class);
	
	@Override
	public List<Suggest> selectSuggest () {
		return jdbctemplate.query("SELECT * FROM suggest AS A"
				+ " LEFT OUTER JOIN request AS B"
				+ " ON A.request_no = B.request_no", rowMapper);
	}

	@Override
	public int insertSuggest(Suggest suggest) {
		return jdbctemplate.update("INSERT INTO suggest (teacher_id, request_no, price, `date`, message)"
				+ " VALUES (?, ?, ?, ?, ?)", suggest.getId(), suggest.getRequestNo(), suggest.getPrice(), suggest.getDate(), suggest.getMessage());
	}
}
