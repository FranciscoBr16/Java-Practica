package entities;

public class Product {
	
	private int ID;
	private String name;
	private String description;
	private double price;
	private int stock;
	private boolean shippingIncluded;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String desctiption) {
		this.description = desctiption;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isShippingIncluded() {
		return shippingIncluded;
	}
	public void setShippingIncluded(boolean shippingIcluded) {
		this.shippingIncluded = shippingIcluded;
	}
	
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String toString() {
		String envio; 
		if (this.isShippingIncluded()) {
			envio = "Envio Incluido";
		} else envio = "El envio no está Incluido";
		
		return "[NOMBRE]: "+this.getName()+"\n[DESCRIPCION]: "+this.getDescription()+ "\n[STOCK]: "+ this.getStock() +"\n[PRECIO]: $"+this.getPrice()+"\n"+envio+"\n-----------------------------";  
	}

}
