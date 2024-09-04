package Controller;
import java.util.*;

import Model.DeliveryDAO;
public class Delivery {
	DeliveryDAO ddao=new DeliveryDAO();
	public boolean setStatus(String id) {
	UUID uuid = UUID.randomUUID();
    String randomString = uuid.toString();
    String delstatus="delivered/cd";
    if(ddao.updateDeliveryStatus(id,randomString,delstatus)) {
    	return true;
    }
    return false;
	}
	
}
