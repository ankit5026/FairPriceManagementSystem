package Controller;
import java.util.*;
import Model.CustomerDAO;

public class Customer {
	private String c_id;
	private String name;
	private String address;
	private String phno;
	private String cardno;
	private String password;
	CustomerDAO dao=new CustomerDAO();
	public Customer(String id,String n,String add,String no,String cno,String psw) {
		setId(id);
		setName(n);
		setAddress(add);
		setPhno(no);
		setCardno(cno);
		setPassword(psw);
	}
	public void setPassword(String ps) {
		password=ps;
	}
	public String getPassword() {
		return password;
	}
	public void setId(String id) {
		c_id=id;
	}
	public void setName(String n) {
		name=n;
	}
	public void setAddress(String add) {
		address=add;
	}
	public void setPhno(String no) {
		phno=no;
	}
	public void setCardno(String cno) {
		cardno=cno;
	}
	public String getId() {
		return c_id;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public String getPhno() {
		return phno;
	}
	public String getCardno() {
		return cardno;
	}
	public  boolean addCustomer(Customer c){
		if(dao.addCustomer( c)) {
			return true;
		}
		return false;
	}
	
	
}
