package Model;

import java.sql.Connection;
import java.sql.*;
import fairpriceSystem.ConnectionEst;

public class AdminDAO {
	ConnectionEst conn=new ConnectionEst();
	Connection connection=conn.connect();
	public boolean existingAdmin(String name,String password) {
		try(Statement statement =connection.createStatement()){
			String s1="SELECT * FROM admin WHERE username = '"+name+"' AND password='"+password+"'";
			ResultSet rs=statement.executeQuery(s1);
			while(rs.next()==true) {
				return true;
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}
}
