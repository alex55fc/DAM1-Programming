package cositas_01;

public class Videojuego {

	//atributo 1
	private String nombre;
	private String desarrollador;
	private int agno;
	private int numeroMaximoJugadores;
	
	//constructor 1
	public Videojuego(String nombre, String desarrollador, int agno,int numeroMaximoJugadores ) {
	this.nombre = nombre;
	this.desarrollador = desarrollador;
	this.agno = agno;
	this.numeroMaximoJugadores = numeroMaximoJugadores;
	}
	
	// constructor 2
	public Videojuego(String nombre, String desarrollador, int agno) {
		this.nombre = nombre;
		this.desarrollador = desarrollador;
		this.agno = agno;
		this.numeroMaximoJugadores = 1; // en el enunciado pide q sea solo un jugadore
		}
	// constructor 3
	public Videojuego(String nombre, String desarrollador) {
		this.nombre = nombre;
		this.desarrollador = desarrollador;
		this.agno = 2021;
		this.numeroMaximoJugadores = 1;
		}
	
	// hacemos un método que devuelve una cadeno de carecteres con el estado del videojuego
	public String obtenerEstado() {
		return   // ponemos primero el nombre de la clase 
				"Videojuego [Nombre = " + nombre + ", Desarrollador = " + desarrollador + 	
				", Año = " + agno + ", NumMaxJugadore = " + numeroMaximoJugadores + "]";
	}

}
