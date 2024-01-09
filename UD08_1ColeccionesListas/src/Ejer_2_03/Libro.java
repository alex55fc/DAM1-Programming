package Ejer_2_03;

import java.util.Objects;

public class Libro {
	//atributos 
	private String isbn; //unico, utilizado para identificar
	private String titulo;
	private String escritor;
	private int añoPublicacion;
	private int stock;
	private double precio;
	
	//constructo con los un parametro 
	public Libro(String isbn) {
		this.isbn = isbn;
	}
	//constructor
	public Libro(String isbn, String titulo, String escritor, int añoPublicacion, int stock, double precio) {
		this.isbn = isbn;
		this.titulo = titulo;
		this.escritor = escritor;
		this.añoPublicacion = añoPublicacion;
		this.stock = stock;
		this.precio = precio;
	}
	
	//toString
	@Override
	public String toString() {
		return "Libro [isbn=" + isbn + ", titulo=" + titulo + ", escritor=" + escritor + ", añoPublicacion="
				+ añoPublicacion + ", stock=" + stock + ", precio=" + String.format("%.2f", precio)+ "]";
	}

	
	//get
	public String getIsbn() {
		return isbn;
	}
	
	public double getPrecio() {
		return precio;
	}
	

	public String getEscritor() {
		return escritor;
	}
	
	
	public int getStock() {
		return stock;
	}
	//asi decrementamos el stockd de unidades, en la clase libro 
	//nos aseguramos que el stock no sea negativo si decrmentamos por lo que comprobamos que stock sea mayor q 0
	public void decrementarNumeroUnidades() {
		if(this.stock > 0) {
			this.stock--;
		}
	}

	//SOLO PARA LISTAS, con el HashCode and equals marcamos lo que queremos comparar y seleccionamos todas las opciones de debajo
	// con esto comparamos los isbn para que no coincidadn
	@Override
	public int hashCode() {
		return Objects.hash(isbn);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Libro)) {
			return false;
		}
		Libro other = (Libro) obj;
		return Objects.equals(isbn, other.isbn);
	}
	
	
	
	
	
	
	
}
