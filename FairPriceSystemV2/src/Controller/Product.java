package Controller;

import Model.ProductDAO;

public class Product {
	private String product_id;
	private String product_name;
	private int product_price;
	private double quantity;
	ProductDAO dao=new ProductDAO();
	public Product(String id,String name,int price,double quantity) {
		setId(id);
		setName(name);
		setPrice(price);
		setQuantity(quantity);
	}
	public void setId(String id) {
		product_id=id;
	}
	public void setName(String name) {
		product_name=name;
	}
	public void setPrice(int price) {
		product_price=price;
	}
	public String getId() {
		return product_id;
	}
	public String getName() {
		return product_name;
	}
	public int getPrice() {
		return product_price;
	}
	public void setQuantity(double quant) {
		quantity=quant;
	}
	public double getQuantity() {
		return quantity;
	}
	public  boolean addProduct(Product p){
		if(dao.addProduct( p)) {
			return true;
		}
		return false;
	}
	@Override
	    public String toString() {
	        return "Product{" +
	                "id='" + product_id + '\'' +
	                ", name='" + product_name + '\'' +
	                ", price=" + product_price +
	                ", quantity=" + quantity +
	                '}';
	    }
}
