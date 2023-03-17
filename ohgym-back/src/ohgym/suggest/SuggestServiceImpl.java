package ohgym.suggest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuggestServiceImpl implements SuggestService {
	@Autowired
	public SuggestDAO dao;

	@Override
	public List<Suggest> selectSuggest() {
		return dao.selectSuggest();
	}

	@Override
	public int insertSuggest(Suggest suggest) {
		return dao.insertSuggest(suggest);
	}
}
