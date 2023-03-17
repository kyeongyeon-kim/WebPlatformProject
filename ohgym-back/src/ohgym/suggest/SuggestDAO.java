package ohgym.suggest;

import java.util.List;

public interface SuggestDAO {
	List<Suggest> selectSuggest();
	int insertSuggest(Suggest suggest);
	
}
