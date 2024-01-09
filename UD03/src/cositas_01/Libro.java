package cositas_01;

public class Libro {
//los nombre de las variables que llamameos aqui, en el MAIN se pueden llamar distinto
	//atributos
	private String titulo;
	private int numeroEjemplares;
	private double precio;

	//constructor (aqui distinguimos el atributo(titulo) del objeto(titulo) con un this.
	public Libro(String titulo, int numeroEjemplares, double precio) {
		this.titulo = titulo;
		this.numeroEjemplares = numeroEjemplares;
		this.precio = precio;
	}
	// método -- devuelve una caena de caracteres con el estado del libro
	public String obtenerEstado() {
		return
				"Libro [Título = "+ titulo +	
				", Número ejemplares = "+ numeroEjemplares + 
				", Precio = "+ String.format("%.2f", precio) +"]"; 
		 		//escribimos String.format para escribir el precio con 2 decimales
	}

	// usamos los get para devolver el titulo
	public String getTitulo() {
		return titulo;
	}
	
	// usamos set para modificar el titulo
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}
