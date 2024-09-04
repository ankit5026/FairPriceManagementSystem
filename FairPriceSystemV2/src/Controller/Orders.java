package Controller;
import java.util.*;
import java.time.LocalDate;
import Model.OrdersDAO;
public class Orders {
	OrdersDAO dao=new OrdersDAO();
	public int orderUpdate(String id,double qty) {
		
		int total=0;
			int amt=dao.getAmount(id,qty);
			
		
		return amt;
	}
	public boolean orderPlaced(String order_id,String card_no,int amt) {
		LocalDate currentDate = LocalDate.now();
		String date=currentDate.toString();
		if(dao.order(order_id,card_no,date,amt,0)) {
			return true;
		}
		return false;
	}
	public boolean orderPlaced(String order_id,String cardno,int amt,int status) {
		LocalDate currentDate = LocalDate.now();
		String date=currentDate.toString();
		if(dao.order(order_id,cardno,date,amt,0)) {
			return true;
		}
		return false;
	}
	public void orderProcess(String id,LinkedHashMap<String,Double>map) {
	
		for(Map.Entry<String,Double>l:map.entrySet()) {
			dao.addOrder(id, l.getKey(), l.getValue());
		}
	}
}
