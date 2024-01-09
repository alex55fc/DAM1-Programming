package Ejer_practico;

public abstract class Video {
	
	//atributo static
	private static int contador = 0;
	
	//atributo
	protected int codigo;
	protected String titulo;
	
	//constructor
	public Video (String titulo) {
		contador++;
		this.codigo = contador;
		this.titulo = titulo;
	}
	
	//toString 
	@Override 
	public String toString() {
		return "Videos [Codigo= "+ codigo + ", Titulo= "+ titulo;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public abstract double calcularPuntuacion();
}
