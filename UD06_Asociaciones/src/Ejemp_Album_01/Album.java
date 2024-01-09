package Ejemp_Album_01;

public class Album {
	//atributos 
	private String nombre;
	private String artista;
	private int agnoPublicacion;
	private String genero;
	
	//constructor, crea un album a partir de parametros
	public Album(String nombre, String artista, int agnoPublicacion, String genero) {
		this.nombre = nombre;
		this.artista = artista;
		this.agnoPublicacion = agnoPublicacion;
		this.genero = genero;
		
	}
		@Override
		//toString devuelve una cadena de caracteres con el estado del album
		public String toString() {
			return "Album[Nombre: "+ nombre +", Artista: "+ artista +
					", Año Publicacion: "+ agnoPublicacion + ", Genero: "+ genero+ "]";
		}
		
		//devuelve el nombre del álbum, lo necesitamos para el metodo consultarPorNombre
		public String getNombre() {
			return nombre;
		}
	
}
