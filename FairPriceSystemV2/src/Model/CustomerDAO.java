package Model;
import java.sql.*;

import Controller.Customer;
import fairpriceSystem.ConnectionEst;


public class CustomerDAO {
	
	ConnectionEst conn=new ConnectionEst();
	Connection connection=conn.connect();
	public boolean addCustomer(Customer cus) {
		try(Statement statement=connection.createStatement()) {
			String q1="INSERT INTO customer VALUES('"+cus.getId()+"','"+cus.getName()+"','"+cus.getAddress()+"','"+cus.getPhno()+"','"+cus.getCardno()+"','"+cus.getPassword()+"')";
			int r=statement.executeUpdate(q1);
			if(r>0) {
				return true;
			}
			
			}
		catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}
	public boolean modifyCustomerName(String cardno,String name) {
		try(Statement statement = connection.createStatement()){
			String q1="UPDATE customer SET customer_name='"+name+"' WHERE customer_cardno = '"+cardno+"'";
			int r=statement.executeUpdate(q1);
			if(r>0) {
				return true;
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}
	public boolean modifyCustomerAddress(String cardno,String address) {
		try(Statement statement =connection.createStatement()){
			String q1="UPDATE customer SET customer_address = '"+address+"' WHERE customer_cardno = '"+cardno+"'";
			int r=statement.executeUpdate(q1);
			if(r>0) {
				return true;
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}
	public boolean modifyCustomerPhno(String cardno,String phno) {
		try(Statement statement=connection.createStatement()){
			String q1="UPDATE customer SET customer_phno='"+phno+"' WHERE customer_cardno = '"+cardno+"'";
			int r=statement.executeUpdate(q1);
			if(r>0) {
				return true;
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}
	public boolean deleteCustomer(String cardno) {
		try(Statement statement = connection.createStatement()){
			String s1="DELETE FROM customer WHERE customer_cardno = '"+cardno+"'";
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
	public boolean exisitingCustomer(String id,String password) {
		try(Statement statement=connection.createStatement()){
			String q1="SELECT * from customer where customer_cardno='"+id+"' AND password = '"+password+"'";
			ResultSet rs=statement.executeQuery(q1);
			if(rs.next()==true) {
				return true;
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
}
