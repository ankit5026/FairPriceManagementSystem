package View;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

import Controller.Customer;
import Controller.Orders;
import Controller.Product;
import Model.CustomerDAO;
import Model.OrdersDAO;
import Model.ProductDAO;
import Model.TransactionDAO;

public class AdminView {
	public static void adminOperations() {
		Scanner sc=new Scanner(System.in);
		int choice=9;
		do {
		System.out.println("Enter 1 for Customer Manipulation");
		System.out.println("Enter 2 for Product Manipulation");
		System.out.println("Enter 3 to place Order");
		System.out.println("Enter 0 to exit");
		choice =sc.nextInt();
		if(choice==1) {
			
		System.out.println("\nCustomer Manipulation\n");
		System.out.println("Enter 1 to add customer");
		System.out.println("Enter 2 to modify customer");
		System.out.println("Enter 3 to delete customer");
		System.out.println("Enter 0 to exit");
		
		System.out.println();
		CustomerDAO customerd=new CustomerDAO();
		int n=sc.nextInt();
		sc.nextLine();
		if(n==1) {
			System.out.println();
			System.out.println("Enter Customer Id");
			String id=sc.nextLine();
			System.out.println("Enter Customer Name");
			String name=sc.nextLine();
			System.out.println("Enter Customer address");
			String address=sc.nextLine();
			System.out.println("Enter Customer phno");
			String phno=sc.nextLine();
			System.out.println("Enter Customer cardno");
			String cno=sc.nextLine();
			System.out.println("Enter Customer password");
			String psw=sc.nextLine();
			System.out.println();
			Customer c1=new Customer(id,name,address,phno,cno,psw);
			if(c1.addCustomer(c1)) {
				System.out.println("Succesfull");
				System.out.println("");
			}
			else {
				System.out.println("Unable to process your request");
				System.out.println();
			}
			
		}
		else if(n==2) {
			
		
			
			System.out.println("Enter 1 to modify name");
			System.out.println("Enter 2 to modify address");
			System.out.println("Enter 3 to modify phno");
			System.out.println("Enter 0 to exit");
			int ch=sc.nextInt();
			sc.nextLine();
			if(ch==1) {
				System.out.println("Enter card no");
				String cardno=sc.nextLine();
				System.out.println("Enter name to be modified");
				String name=sc.nextLine();
				if(customerd.modifyCustomerName(cardno, name)) {
					System.out.println("Update of name "+name+" for cardno "+cardno+" successfull");
					System.out.println();
				}
				else {
					System.out.println("Unable to process your request");
					System.out.println();
				}
				
			}
			else if(ch==2) {
				System.out.println("Enter card no");
				String cardno=sc.nextLine();
				System.out.println("Enter address to be modified");
				String address =sc.nextLine();
				if(customerd.modifyCustomerAddress(cardno, address)) {
					System.out.println("Update of address "+address+" for cardno "+cardno+" successfull");
					System.out.println();
				}
				else {
					System.out.println("Unable to process your request");
					System.out.println();
				}
				
			}
			else if(ch==3) {
				System.out.println("Enter card no");
				String cardno=sc.nextLine();
				System.out.println("Enter phone number");
				String phno=sc.nextLine();
				if(customerd.modifyCustomerPhno(cardno, phno)) {
					System.out.println("Update of phone number "+phno+" for cardno "+cardno+" successfull");
					System.out.println();
				}
				else {
					System.out.println("Unable to process your request");
					System.out.println();
				}
			}
			
		
		}
		else if(n==3) {
			
			
				
			
			System.out.println("Enter cardno to be deleted");
			String cardno=sc.nextLine();
			if(customerd.deleteCustomer(cardno)) {
				System.out.println("Customer Deleted Sucessfully");
				System.out.println();
			}
			else {
				System.out.println("Unable to process request");
				System.out.println();
			}
		
		}
		}
		else if(choice==2) {
			ProductDAO pdao=new ProductDAO();
			int na=9;
			do {
			System.out.println("\nProduct Manipulation\n");
			System.out.println("Enter 1 to add Product");
			System.out.println("Enter 2 to modify Product");
			System.out.println("Enter 3 to delete Product");
			System.out.println("Enter 4 to display product");
			System.out.println("Enter 0 to exit");
			System.out.println();
			 na=sc.nextInt();
			sc.nextLine();
			if(na==1) {
				System.out.println();
				System.out.println("Enter product id");
				String id=sc.nextLine();
				System.out.println("Entre product Name");
				String name=sc.nextLine();
				System.out.println("Enter product price");
				int price=sc.nextInt();
				System.out.println("Enter product quantity");
				double qty=sc.nextDouble();
				Product p1=new Product(id,name,price,qty);
				if(p1.addProduct(p1)) {
					System.out.println("Successfull");
				}
			}
			else if(na==2) {
				System.out.println("Enter 1 to modify product price");
				System.out.println("Enter 2 to modify product name");
				int k=sc.nextInt();
				sc.nextLine();
				if(k==1) {
					System.out.println("Enter product id");
					String p_id=sc.nextLine();
					System.out.println("Enter product price");
					int price=sc.nextInt();
					if(pdao.modifyPrice(p_id, price)){
						System.out.println("Successfull");
					}
				}
				else if(k==2) {
					System.out.println("Enter product id");
					String p_id=sc.nextLine();
					System.out.println("Enter product name");
					String name=sc.nextLine();
					if(pdao.modifyName(p_id,name)) {
						System.out.println("Successfull");
					}
				}
			}
			else if(na==3) {
				System.out.println("Enter product id to be deleted ");
				String id=sc.nextLine();
				System.out.println("Enter quantity of product to be deleted");
				double quantity=sc.nextDouble();
				if(pdao.deleteProduct(id,quantity)) {
					System.out.println("Successfull");
				}
			}
			else if(na==4) {
				
				List<Product>products=pdao.displayProducts();
				if(products!=null && !products.isEmpty()) {
					System.out.println("Products ");
					for(Product p:products) {
						System.out.println(p);
					}
					System.out.println();
			}
			}
			//na=sc.nextInt();
			}while(na!=0);
		}
		else if(choice==3) {
			int no=9;
			do {
			System.out.println("\nOrder Manipulation\n");
			System.out.println("Enter 1 to place order");
			System.out.println("Enter 0 to exit");
			no=sc.nextInt();
			sc.nextLine();
			if(no==1) {
			System.out.println("Enter card_no");
			String cardno=sc.nextLine();
			UUID uuid = UUID.randomUUID();
	        String randomString = uuid.toString();
	        System.out.println();
	        ProductDAO pdao=new ProductDAO();
	        List<Product>products=pdao.displayProducts();
			if(products!=null && !products.isEmpty()) {
				System.out.println("Products ");
				for(Product p:products) {
					System.out.println(p);
				}
				System.out.println();
			}
		int np=9;int tot=0;
		LinkedHashMap<String , Double>map=new LinkedHashMap<>();
		Orders ord=new Orders();
		do {
		System.out.println("Enter product id");
		String id=sc.nextLine();
		System.out.println("Enter quantity");
		double qty=sc.nextDouble();
		OrdersDAO dao=new OrdersDAO();
		int amt = dao.getAmount(id,qty);
		map.put(id,qty);
		if(amt<=0) {
			System.out.println("Stock not available");
		}
		else {
			dao.updateInventory(id,qty);
			tot+=(amt*qty);
		}
		System.out.println("Enter 0 to proceed / other numbers to continue adding ");
		np=sc.nextInt();
		sc.nextLine();
		}while(np!=0);
		System.out.println("*******Generated Bill********");
		System.out.println("Product 	quantity");
		
		for(Map.Entry<String,Double>l:map.entrySet()) {
			System.out.println(l.getKey()+"		"+l.getValue());
		}
		System.out.println();
		System.out.println("Total amount "+tot+"\nEnter 1 to proceed to pay ");
		int paid =sc.nextInt();
		if(paid==1) {
		if(ord.orderPlaced(randomString,cardno,tot,paid)) {
			TransactionDAO t=new TransactionDAO();
			UUID uu = UUID.randomUUID();
	        String transid = uu.toString();
			t.tansaction(cardno,randomString,transid,tot,"physical");
			System.out.println("Successfull");
		}
		}
		else {
			
			System.out.println("Aborted as Amount not paid");
		}
		if(paid==1)
		ord.orderProcess(randomString,map);
		
			}	
		}while(no!=0);
		}
		
		}while(choice!=0);
	}		
		
	
	public static void main(String args[]) {
		AdminView.adminOperations();
	}
}
