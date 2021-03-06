package shipagent.shipinfo;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shipagent.db.DbConnector;

@SuppressWarnings("serial")
public class DeleteshipinfoServlet extends HttpServlet{
	private String EnglishshipName = null;
	
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		EnglishshipName = new String(req.getParameter("EnglishshipName").getBytes("iso-8859-1"),"utf-8");
		
		try {
			if(delete()){
				//resp.getWriter().println("success!");
				resp.sendRedirect("/shipagent/shipinfoform/shipinfo.html");
			}
			else{
				//resp.getWriter().println("error!");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean delete() throws SQLException{
		String sql ="delete from t_ship_info where EnglishName="+"'"+EnglishshipName+"'";
		
		DbConnector conn = new DbConnector();
		int num = conn.delete(sql);
		
		if(num>=1){
			return true;
		}
		else{
			return false;
		}
	}
}
