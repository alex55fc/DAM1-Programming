package Ejer_1_01;

public class Videojuego {
	
	/* Cuando la tienda saca un nuevo
	videojuego a la venta, se le asignará el código siguiente al código del último videojuego que se creó. Si la
	tienda deja de vender un videojuego, el código de ese videojuego no se reutilizará para otro videojuego. por esto creamos esto*/
	//atributo de clase para contar videojuegos
	private static int contador = 0;

	//atributo
	public int codigoAutogenerado;
	private String titulo;
	private double precio;
	private int cantidad;
	
	//constructor
	public Videojuego(String titulo, double precio) {
		contador++;
		this.codigoAutogenerado =contador;
		this.titulo = titulo;
		this.precio = precio;
		this.cantidad = 10;
	}
	
	@Override
	public String toString() {
		return "Videojuego [ Codigo Autogenerado: "+ codigoAutogenerado +
				", titulo: "+ titulo +"precio: "+ String.format("%2.2f", precio)+ ", cantidad: "+ cantidad +"]";
	}
	
}
