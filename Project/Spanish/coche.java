
public class coche {
	
	
	private int numero_puertas;
	
	private double precio;
	
	private String color;
	
	private String modelo;
	
	private String marca;
	
	private String carroceria;

	
	
	public coche (int numero_puertas, double precio, String color, String modelo, String marca, String carroceria) {
		
		this.numero_puertas = numero_puertas;
		
		this.precio = precio;
		
		this.color = color;
		
		this.modelo = modelo;
		
		this.marca = marca;
		
		this.carroceria = carroceria;
		
		
	}
		
	public void setNumero_puertas(int numero_puertas) {
		
		this.numero_puertas = numero_puertas;		
	}
	
	public int getNumero_puertas() {
		
		return this.numero_puertas;		
	}
	
	
	
	public void setPrecio(double precio) {
		
		this.precio = precio;		
	}
	
	public double getPrecio() {
		
		return this.precio;
	}
	
	
	
	public void setColor(String color) {
		
		this.color = color;		
	}
	
	public String getColor() {
		
		return this.color;
	}
	
	
	
	public void setModelo(String modelo) {
		
		this.modelo = modelo;		
	}
	
	public String getModelo() {
		
		return this.modelo;
	}

	
	
	public String getMarca() {
		
		return marca;
	}

	public void setMarca(String marca) {
		
		this.marca = marca;
	}
	
	
	
	public String getCarroceria() {
		
		return carroceria;
		
	}
	
	public void setCarroceria(String carroceria) {
		
		this.carroceria = carroceria;
		
	}

	
	public String toString() {
		
		return 	"\n                                      Características\n" + 
				"\n Marca del coche ............... 	" + getMarca() +
				"\n Modelo del coche .............. 	" + getModelo() +
				"\n Carroceria del coche .......... 	" + getCarroceria() +
				"\n Color del coche ............... 	" + getColor() +
				"\n Precio del coche .............. 	" + getPrecio() + " €" +
				"\n Numero de puertas del coche ... 	" + getNumero_puertas() + "\n";
		
	}


}
