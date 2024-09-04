package View;
import java.util.*;

import Controller.Delivery;
import Model.DeliveryDAO;
public class DeliveryMenView {
	public void deliveryOperations() {
		Scanner sc=new Scanner(System.in);
		int n=9;
		do {
	System.out.println("Enter 1 for delivery status");
	System.out.println("Enter 2 for payment and delivery status");
	System.out.println("Enter 0 to quit");
	n=sc.nextInt();
	DeliveryDAO ddao=new DeliveryDAO();
	Delivery del=new Delivery();
	sc.nextLine();
	if(n==1) {
		System.out.println("Enter order_id to set delivery status");
		String id=sc.nextLine();
		if(ddao.updateDeliveryStatus(id)) {
			System.out.println("Successfull");
		}
	}
	else if(n==2) {
		System.out.println("Enter order_id to set payment and delivery status");
		String id=sc.nextLine();
		System.out.println(ddao.getAmt(id));
		System.out.println();
		System.out.println("Enter 1 to proceed payment");
		int k=sc.nextInt();
		if(k==1) {
			if(del.setStatus(id)) {
				System.out.println("Successfull");
			}
		}
	}
	}while(n!=0);
	}
}
