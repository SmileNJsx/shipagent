package shipagent.data;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import shipagent.db.DbConnector;

@SuppressWarnings("serial")
public class DataJson extends HttpServlet{
	
	ArrayList<String> EnglishshipName = new ArrayList<String>();
	ArrayList<String> ChineseshipName = new ArrayList<String>();
	ArrayList<String> Add_user = new ArrayList<String>();
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		
		System.out.println("hello");
		String sql = "select * from t_ship_info limit 100";
		int i=0;
		DbConnector conn = new DbConnector();
		
		try {
			EnglishshipName = conn.selectlist(sql, "EnglishName");
			ChineseshipName = conn.selectlist(sql, "ChineseName");
			Add_user = conn.selectlist(sql, "Add_user");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String data = "[";
		
		for(;i<(EnglishshipName.size()-1);i++){
			data=data+"{\"EnglishshipName\":"+"\""+EnglishshipName.get(i)+"\","
			+"\"ChineseshipName\":"+"\""+ChineseshipName.get(i)+"\","
			+"\"Add_user\":"+"\""+Add_user.get(i)+"\""
			+"},";
		}
		
		data=data+"{\"EnglishshipName\":"+"\""+EnglishshipName.get(i)+"\","
				+"\"ChineseshipName\":"+"\""+ChineseshipName.get(i)+"\","
				+"\"Add_user\":"+"\""+Add_user.get(i)+"\""
				+"}";
		
		data = data+"]" ;
		
		System.out.println(data);
		
		//String data = "[{\"EnglishshipName\":\"shixiao\",\"ChineseshipName\":\"shixiao\",\"MakeName\":\"shixiao\"}]";
		
		resp.setCharacterEncoding("UTF-8");
		//resp.setHeader("Content-Type", "text/html;charset=UTF-8");
		resp.getWriter().print(data);
	}
}
