package shipagent.Loginaction;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet{
	
	//private String client_username = null;
	//private String client_password = null;
	
	//private String server_username = null;
	//private String server_password = null;
	
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse resp){
		System.out.println(req.getRequestURL());
	}
	
	public boolean verification(){
		return false;
	}
}
