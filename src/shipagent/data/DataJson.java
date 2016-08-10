package shipagent.data;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class DataJson extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		System.out.println("hello");
		
		String data = "[{\"EnglishshipName\":\"shixiao\",\"ChineseshipName\":\"shixiao\",\"MakeName\":\"shixiao\"}]";
		
		resp.setCharacterEncoding("UTF-8");
		//resp.setHeader("Content-Type", "text/html;charset=UTF-8");
		resp.getWriter().print(data);
	}
}
