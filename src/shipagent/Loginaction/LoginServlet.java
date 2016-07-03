package shipagent.Loginaction;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public class LoginServlet extends HttpServlet{
	
	private String client_username = null;
	private String client_password = null;
	
	private String server_username = null;
	private String server_password = null;
	
	LoginServlet(String client_username,String client_password,String server_username,String server_password){
		this.client_username = client_username;
		this.client_password = client_password;
		
		this.server_username = server_username;
		this.server_password = server_password;
	}
	
	protected void doPost(HttpServletRequest req,HttpServlet resp){
		
	}
	
	public boolean verification(){
		return false;
	}
}
