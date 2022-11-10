package H2S_Application.Dao_Uility;

import java.sql.Connection;
import java.sql.DriverManager;

public class connection__ {
	
	
	public static  Connection provideConnection() {
		
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		String url =  "jdbc:mysql://localhost:3306/H3s_database";
		
		
		try  {
			
			connection = DriverManager.getConnection(url,"root","pradeep4899");
			
					
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
		
		return connection;
		
	}

}
