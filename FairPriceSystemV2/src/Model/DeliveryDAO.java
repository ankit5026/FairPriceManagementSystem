package Model;
import java.sql.*;

import fairpriceSystem.ConnectionEst;
public class DeliveryDAO {
	ConnectionEst conn=new ConnectionEst();
	Connection connection=conn.connect();
	public boolean updateDeliveryStatus(String id) {
		try(Statement statement=connection.createStatement()){
			String t="delivered";
			String s1="UPDATE transaction SET delivery_status='"+t+"' where order_id='"+id+"'";
			int r=statement.executeUpdate(s1);
			if(r>0) {
				return true;
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}
public int getAmt(String id) {
		try(Statement statement=connection.createStatement()){
			String s1="SELECT amt FROM transaction where order_id='"+id+"'";
			ResultSet rs=statement.executeQuery(s1);
			int amount=0;
			while(rs.next()) {
				amount=rs.getInt("amt");
			}
			return amount;
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return 0;
	}
public boolean updateDeliveryStatus(String id,String t_id,String status) {
	try(Statement statement =connection.createStatement()){
		String q1="SELECT status FROM transaction where order_id='"+id+"'";
		String trans_id="";
		ResultSet rst=statement.executeQuery(q1);
		while(rst.next()) {
			trans_id=rst.getString("transaction_id");
		}
		if(!trans_id.equals("online/cd")) {
		String s1="UPDATE transaction SET transaction_id = '"+t_id+"',delivery_status = '"+status+"' WHERE order_id = '"+id+"'";
		int u=statement.executeUpdate(s1);
		if(u>0) {
			return true;
		}
		}
	}
	catch(Exception e) {
		System.out.println(e);
	}
	return false;
}
public boolean existingdeliveryGuy(String name,String password) {
	try(Statement statement = connection.createStatement()){
		String q1="SELECT * FROM deliveryguy where username='"+name+"' AND password='"+password+"'";
		ResultSet u=statement.executeQuery(q1);
		while(u.next()==true) {
			return true;
		}
		
	}
	catch(Exception e) {
		System.out.println(e);
	}
	return false;
}

}
