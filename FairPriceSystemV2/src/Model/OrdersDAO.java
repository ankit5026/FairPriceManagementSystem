package Model;
import java.sql.*;

import fairpriceSystem.ConnectionEst;
public class OrdersDAO {
	ConnectionEst conn=new ConnectionEst();
	Connection connection=conn.connect();
	public int getAmount(String id,double qty) {
		int price=0;
		try(Statement statement =connection.createStatement()){
			String q1="SELECT product_price FROM products where product_id = '"+id+"' AND quantity_available >='"+qty+"'";
			ResultSet rs=statement.executeQuery(q1);
			while(rs.next()) {
				price=rs.getInt("product_price");
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return price;
	}
	public boolean order(String id,String cardno,String date,int amt,int status){
		
		
			
				
			try(Statement statement=connection.createStatement()){
				String q1="INSERT INTO orders values('"+id+"','"+cardno+"','"+date+"','"+amt+"','"+status+"')";
				int r1=statement.executeUpdate(q1);
				if(r1>0) {
					return true;
				}
			}
			catch(Exception e) {
				System.out.println(e);
			}
			return false;
	
		
	}
	public boolean addOrder(String id,String p_id,double qty) {
		try(Statement statement = connection.createStatement()){
			String s1="INSERT INTO order_details values ('"+id+"','"+p_id+"','"+qty+"')";
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
	public void updateInventory(String id,double qty) {
		try(Statement statement=connection.createStatement()){
		String q2="SELECT quantity_available from products where product_id = '"+id+"' AND quantity_available >='"+qty+"'";
		ResultSet r=statement.executeQuery(q2);
		double qtyav=0.0;
		while(r.next()) {
			qtyav=r.getDouble("quantity_available");
		}
		double newqty=Math.abs(qtyav-qty);
		String q3="UPDATE products SET quantity_available='"+newqty+"' where product_id='"+id+"'";
		int n=statement.executeUpdate(q3);
	}
	
	catch(Exception e) {
		System.out.println(e);
	}
	}
}
