package ohgym.suggest;

import java.util.List;

public interface SuggestService {
	public List<Suggest> selectSuggest();
	int insertSuggest(Suggest suggest);
}
