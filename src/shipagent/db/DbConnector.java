package shipagent.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnector {
	private static String URL = "jdbc:mysql://127.0.0.1/shipagent";
	private static String USER_NAME = "root";
	private static String PASS_WORD = "Sx930622";
	private static String DRIVER_NAME = "com.mysql.jdbc.Driver";
	
	Connection conn = null;
	
	public DbConnector(){
		try {
			Class.forName(DRIVER_NAME);
			
			conn = DriverManager.getConnection(URL,USER_NAME,PASS_WORD);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String select(String sql,String key) throws SQLException{
		
		String result = null;
		
		Statement statement = conn.createStatement();
		
		ResultSet resultSet = statement.executeQuery(sql);
		
		while(resultSet.next()){
			result = resultSet.getString(key);
		}
		
		return result;
	}
	
	public int insert(String sql) throws SQLException{
		Statement statement = conn.createStatement();
		
		int num = statement.executeUpdate(sql);
		
		System.out.println(num+"rows have been influence");
		
		return num;
	}
}
