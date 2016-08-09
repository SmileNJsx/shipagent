package shipagent.Loginaction;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shipagent.db.DbConnector;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet{
	
	private String client_username = null;
	private String client_password = null;
	
	private String server_password = null;
	
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws UnsupportedEncodingException, IOException{
		client_username = new String(req.getParameter("username").getBytes("iso-8859-1"),"utf-8");
		client_password = new String(req.getParameter("password").getBytes("iso-8859-1"),"utf-8");
		
		try {
			resp.sendRedirect(verification());;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String verification() throws SQLException{
		
		String sql = "select password from t_users where username="+"\""+client_username+"\"";
		
		DbConnector conn = new DbConnector();
		
		server_password = conn.select(sql, "password");
		
		if(server_password == null){
			return "/shipagent/index.html";
		}
		
		if(client_password.equals(server_password)){
			return "/shipagent/shipinfoform/shipinfo.html";
		}
		else{
			return "/shipagent/index.html";
		}
	}
}
