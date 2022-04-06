
/* 
Author:		green-vibes-coding
URL:		-
Version:	1.0
*/

public class car {
	
	
	private int number_doors;
	
	private double price;
	
	private String color;
	
	private String model;
	
	private String brand;
	
	private String bodywork;

	
	
	public car (int number_doors, double price, String color, String model, String brand, String bodywork) {
		
		this.number_doors = number_doors;
		
		this.price = price;
		
		this.color = color;
		
		this.model = model;
		
		this.brand = brand;
		
		this.bodywork = bodywork;
		
		
	}
		
	public void setNumber_doors(int number_doors) {
		
		this.number_doors = number_doors;		
	}
	
	public int getNumber_doors() {
		
		return this.number_doors;		
	}
	
	
	
	public void setPrice(double price) {
		
		this.price = price;		
	}
	
	public double getPrice() {
		
		return this.price;
	}
	
	
	
	public void setColor(String color) {
		
		this.color = color;		
	}
	
	public String getColor() {
		
		return this.color;
	}
	
	
	
	public void setModel(String model) {
		
		this.model = model;		
	}
	
	public String getModel() {
		
		return this.model;
	}

	
	
	public String getBrand() {
		
		return brand;
	}

	public void setBrand(String brand) {
		
		this.brand = brand;
	}
	
	
	
	public String getBodywork() {
		
		return bodywork;
		
	}
	
	public void setBodywork(String bodywork) {
		
		this.bodywork = bodywork;
		
	}

	
	public String toString() {
		
		return 	"\n                                      Features\n" + 
				"\n Brand of the car .............. 	" + getBrand() +
				"\n Model of the car .............. 	" + getModel() +
				"\n Bodywork of the car ........... 	" + getBodywork() +
				"\n Color of the car .............. 	" + getColor() +
				"\n Price of the car .............. 	" + getPrice() + " €" +
				"\n Number of car doors ........... 	" + getNumber_doors() + "\n";
		
	}


}
