package ohgym.signup;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/checkid")
public class CheckIdServlet extends HttpServlet {
	private SignupService service;
	
    @Override
    public void init() throws ServletException {
        super.init();
        service = new SignupService(new SignupDAOImpl());
    }
    
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		System.out.println(id);
		resp.setHeader("Content-Type", "plain/text");
		
		PrintWriter pw = resp.getWriter();
		boolean idDuplicated = service.isDuplicatedId(id);
	
		pw.println(idDuplicated);
		System.out.println(idDuplicated);
		pw.flush();
	}
	
}
