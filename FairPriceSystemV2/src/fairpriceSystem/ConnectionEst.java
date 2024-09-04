package fairpriceSystem;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionEst {

	public static Connection connect() {
		String url="jdbc:mysql://localhost:3306/fairpriceshop_management";
		String username="root";
		String password="";
		Connection connection =null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection =DriverManager.getConnection(url,username,password);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return connection;
	}
}

