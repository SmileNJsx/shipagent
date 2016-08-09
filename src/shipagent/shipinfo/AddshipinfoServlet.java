package shipagent.shipinfo;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class AddshipinfoServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse resp){
		System.out.println("hello");
	}
}
