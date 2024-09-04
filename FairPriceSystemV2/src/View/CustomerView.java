package View;
import java.util.*;
import java.util.UUID;
import Controller.Customer;
import Controller.Orders;
import Controller.Product;
import Model.CustomerDAO;
import Model.OrdersDAO;
import Model.ProductDAO;
import Model.TransactionDAO;
public class CustomerView {
	static String cardno;
	CustomerDAO cusdo=new CustomerDAO();
	public void customerOperation() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter 1 to login");
		int choi=sc.nextInt();
		sc.nextLine();
		if(choi==1) {
			System.out.println("Enter cardno");
			 cardno=sc.nextLine();
			System.out.println("Enter password");
			String password=sc.nextLine();
			if(cusdo.exisitingCustomer(cardno, password)) {
		
		System.out.println("Enter 1 to view Items Available");
		int ch=sc.nextInt();
		ProductDAO dao=new ProductDAO();
		if(ch==1) {
			List<Product>products=dao.displayProducts();
			if(products!=null && !products.isEmpty()) {
				System.out.println("Products ");
				for(Product p:products) {
					System.out.println(p);
				}
				System.out.println();
				System.out.println("Enter 1 to add products");
				int m=sc.nextInt();
				sc.nextLine();
				if(m==1) {
					placeOrder();
					
				}
			}
			else {
				System.out.println(" product available");
			}
		}
		
			}
		}
	}
	public static void placeOrder() {
		Scanner sc=new Scanner(System.in);
		 UUID uuid = UUID.randomUUID();
	        String randomString = uuid.toString();
	        
	        
		int n=9;int tot=0;
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
		n=sc.nextInt();
		sc.nextLine();
		}while(n!=0);
		System.out.println("*******Generated Bill********");
		System.out.println("Product 	quantity");
		
		for(Map.Entry<String,Double>l:map.entrySet()) {
			System.out.println(l.getKey()+"		"+l.getValue());
		}
		System.out.println();
		System.out.println("Total amount "+tot+"\nEnter 1 to proceed to pay ");
		int paid =sc.nextInt();
		TransactionDAO t=new TransactionDAO();
		if(paid==1) {
		if(ord.orderPlaced(randomString,cardno,tot,paid)) {
			UUID uu = UUID.randomUUID();
	        String transid = uu.toString();
			t.tansaction(cardno,randomString,transid,tot,"online");
			System.out.println("Successfull");
		}
		}
		else {
			ord.orderPlaced(randomString,cardno,tot);
			t.tansaction(cardno,randomString,tot,"online/cd");
			System.out.println("Order Successfull payment pending");
		}
		ord.orderProcess(randomString,map);
	}
	
	public static void main(String args[]) {
		CustomerView cv=new CustomerView();
		cv.customerOperation();
	}
}
