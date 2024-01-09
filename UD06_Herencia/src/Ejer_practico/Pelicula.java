package Ejer_practico;

public class Pelicula extends Video {
	
	//atributos
	protected int añoCreacion;
	protected String director;
	
	//constructor
	public Pelicula(String titulo
			, int añoCreacion, String director) {
		super(titulo);
		this.añoCreacion = añoCreacion;
		this.director = director;
	}
	//toString
	public String toString() {
		return "Pelicula [Codigo= "+ codigo + ", Titulo= "+ titulo
				+ ",Año cracion "+ añoCreacion +", Director "+ director;
	}
	
	@Override 
	public double calcularPuntuacion() {
		return 1.2+1.3;
	}
	public String getDirector() {
		return director;
	}

}

