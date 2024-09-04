package Model;
import java.sql.*;

import fairpriceSystem.ConnectionEst;
public class TransactionDAO {
	public boolean tansaction(String cardno,String o_id,String t_id,int amt,String status) {
		ConnectionEst conn=new ConnectionEst();
		Connection connection=conn.connect();
		try(Statement statement=connection.createStatement()){
			String q1="INSERT INTO transaction (card_no,order_id,transaction_id,amt,status) VALUES ('"+cardno+"','"+o_id+"','"+t_id+"','"+amt+"','"+status+"')";
			int r=statement.executeUpdate(q1);
			if(r>0) {
				return true;
			}
			return false;
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}
	public boolean tansaction(String cardno,String o_id,int amt,String status) {
		ConnectionEst conn=new ConnectionEst();
		Connection connection=conn.connect();
		try(Statement statement=connection.createStatement()){
			String q1="INSERT INTO transaction (card_no,order_id,amt,status) VALUES ('"+cardno+"','"+o_id+"','"+amt+"','"+status+"')";
			int r=statement.executeUpdate(q1);
			if(r>0) {
				return true;
			}
			return false;
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}
}
