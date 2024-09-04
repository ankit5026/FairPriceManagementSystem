package fairpriceSystem;
import java.util.*;

import Model.AdminDAO;
import Model.DeliveryDAO;
import View.AdminView;
import View.CustomerView;
import View.DeliveryMenView;
public class Main {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		DeliveryDAO ddao=new DeliveryDAO();
		System.out.println("Enter 1 for Admin\n2 for Customer\n3 for Delivery Guy");
		int choice=sc.nextInt();
		sc.nextLine();
		if(choice==1) {
			AdminDAO adao=new AdminDAO();
			System.out.println("Enter username ");
			String name=sc.nextLine();
			System.out.println("Enetr password");
			String pswd=sc.nextLine();
			if(adao.existingAdmin(name, pswd)){
				System.out.println("**********************Welcome Admin*********************");
				System.out.println();
				AdminView av=new AdminView();
				av.adminOperations();
				
			}
		}
		if(choice==2) {
			CustomerView cv=new CustomerView();
			cv.customerOperation();
			
		}
		if(choice==3) {
			System.out.println("Enter 1 to login");
			int u=sc.nextInt();
			sc.nextLine();
			if(u==1) {
				System.out.println("Enter user name");
				String s=sc.nextLine();
				System.out.println("Enter password");
				String ps=sc.nextLine();
				if(ddao.existingdeliveryGuy(s,ps)) {
					DeliveryMenView dv=new DeliveryMenView();
					dv.deliveryOperations();
					
				}
			}
		}
	}
}
