package entities;

public class Product {
	
	private int ID;
	private String name;
	private String desctiption;
	private double price;
	private boolean shippingIcluded;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesctiption() {
		return desctiption;
	}
	public void setDesctiption(String desctiption) {
		this.desctiption = desctiption;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isShippingIcluded() {
		return shippingIcluded;
	}
	public void setShippingIcluded(boolean shippingIcluded) {
		this.shippingIcluded = shippingIcluded;
	}
	

}
