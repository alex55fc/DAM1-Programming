package Ejer_usuario;

public class Producto {
	//atributos 
	private String nombre;
	private double precio;
	
	//Constructor
	public Producto(String nombre, double precio) {
		this.nombre = nombre;
		this.precio = precio;
	}
	//toString 
	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", precio=" + String.format("%.2f", precio) + "]";
	}
	
	
}
