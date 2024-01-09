package cositas_01;
// primer paso definir clase con los datos que necesitemos;

public class Pelicula {

	//atributos( en privado )
	// si no lo defino privado cualquier otro programa podria acceder y modificarlo sin que nos dieramos cuenta
	// siempre privado a no ser que nos digan lo contario
	private String nombre;
	private int duracion;
	private boolean dobladaCastellano;
	private double puntuacion;
	
	// constructor nombre igual que la class (Pelicula)
	public Pelicula(String nombre, int duracion, boolean dobladaCastellano, double puntuacion) {
		this.nombre = nombre;
		this.duracion = duracion;
		this.dobladaCastellano = dobladaCastellano;
		this.puntuacion = puntuacion;
	}
	
	// métodos de acceso para optener atributos 
	public String getNombre() {
		return nombre;
	}
	public int getDuracion() {
		return duracion;
	}
	public boolean getDobladaCastellano() {
		return dobladaCastellano;
	}
	
	public double getPuntuacion() {
		return puntuacion;
	}
	
	// métodos de accso a atribuos (setters) (para modificarlos)
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public void setDobladaCastellano (boolean dobladaCastellano) {
		this.dobladaCastellano = dobladaCastellano;
	}
	public void setPuntuacion (double puntuacion) {
		this.puntuacion = puntuacion;
	}
	
	// metodo que devuelve una cadena de carecteres con el estado del objeto
	
	public String obtenerEstado() {
		return 
			"Película [Nombre = " + nombre + ", Duracion = "+ duracion + 	
			", DobladaCastellano = " +dobladaCastellano+ ", Puntuacion = " + puntuacion + "]";
		
	}
	
	
}
