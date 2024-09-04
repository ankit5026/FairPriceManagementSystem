package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import Controller.Product;
import fairpriceSystem.ConnectionEst;

public class ProductDAO {
	ConnectionEst conn=new ConnectionEst();
	Connection connection=conn.connect();
	public boolean addProduct(Product pro) {
			try(Statement statement = connection.createStatement()){
				String q1="INSERT INTO products VALUES ('"+pro.getId()+"','"+pro.getName()+"','"+pro.getPrice()+"','"+pro.getQuantity()+"')";
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
	public boolean modifyPrice(String p_id,int price) {
		try(Statement statement =connection.createStatement()){
			String s1="UPDATE products SET product_price='"+price+"' WHERE product_id='"+p_id+"'";
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
	public boolean modifyName(String p_id,String name) {
		try(Statement statement = connection.createStatement()){
			String s1="UPDATE products SET product_name='"+name+"' WHERE product_id='"+p_id+"'";
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
	public boolean deleteProduct(String p_id,double quant) {
		try(Statement statement = connection.createStatement()){
			String q1="SELECT quantity_available FROM products WHERE product_id='"+p_id+"'";
			ResultSet rs=statement.executeQuery(q1);
			double qty=0;
			while(rs.next()) {
				qty=rs.getDouble("quantity_available");
			}
			if(quant<qty) {
			double newqty=Math.abs(qty-quant);
			
			String s1="UPDATE products SET quantity_available ='"+newqty+"' WHERE product_id = '"+p_id+"'";
			int r=statement.executeUpdate(s1);
			if(r>0) {
				return true;
			}
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}
	public List<Product> displayProducts() {
		List<Product> productList=new ArrayList<>();
		try(Statement statement=connection.createStatement()){
			ResultSet rs=statement.executeQuery("SELECT * FROM products");
			while(rs.next()) {
				Product product= new Product(rs.getString("product_id"),rs.getString("product_name"),rs.getInt("product_price"),rs.getDouble("quantity_available"));
				productList.add(product);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return productList;
	}
}
