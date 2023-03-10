package ohgym.suggest;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;


@WebServlet("/sendSuggest")
public class SendSuggestServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BufferedReader reader = req.getReader();
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			sb.append(line);
		}
		ObjectMapper mapper = new ObjectMapper();
		String strSuggest = sb.toString();
		Suggest suggest = mapper.readValue(strSuggest, Suggest.class);
		SuggestService service = new SuggestServiceImpl(new SuggestDAOImpl());
		int result = service.insertSuggest(suggest);
		
		req.getRequestDispatcher("/views/requestList.jsp").forward(req, resp);
	}
}
