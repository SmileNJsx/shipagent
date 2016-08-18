package shipagent.shipinfo;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shipagent.db.DbConnector;

@SuppressWarnings("serial")
public class ModifyshipinfoServlet extends HttpServlet{
	private String EnglishshipName = null;
	private String ChineseshipName = null;
	private String Add_user = null;
	
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		EnglishshipName = new String(req.getParameter("EnglishshipName").getBytes("iso-8859-1"),"utf-8");
		ChineseshipName = new String(req.getParameter("ChineseshipName").getBytes("iso-8859-1"),"utf-8");
		Add_user = new String(req.getParameter("Add_user").getBytes("iso-8859-1"),"utf-8");
		
		try {
			if(update()){
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
	
	public boolean update() throws SQLException{
		String sql = "update t_ship_info set ChineseName="+"'"+ChineseshipName+"'"+",Add_user="+"'"+Add_user+"'"+"where EnglishName="+"'"+EnglishshipName+"'";
		
		DbConnector conn = new DbConnector();
		int num = conn.update(sql);
		
		if(num>=1){
			return true;
		}
		else{
			return false;
		}
	}
	
}
