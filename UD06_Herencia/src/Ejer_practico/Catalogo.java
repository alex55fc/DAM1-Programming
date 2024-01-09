package Ejer_practico;

public class Catalogo {
	// atributos
	private Video[] vecVideo;
	private int contador;

	// constructor
	public Catalogo(int capacidad) {
		this.vecVideo = new Video[capacidad];
		this.contador = 0;
	}

	// toString
	public String toString() {
		String cadena = "";
		for (int pos = 0; pos < contador; pos++) {
			Video x = vecVideo[pos];
			cadena = cadena + "(" + pos + ") " + x.toString() + ", Puntuacion= " + x.calcularPuntuacion() + "]\n";
		}
		return cadena;
	}

	public boolean estaVacio() {
		return (contador == 0);
	}
	public boolean estaLleno() {
		return(contador == vecVideo.length);
	}
	public int obtenerNumVideosGuardados() {
		return (contador);
	}

	// insertar pelicula o serie
	public boolean insertar(Video video) {
		if (contador < vecVideo.length) {
			vecVideo[contador] = video;
			contador++;
			return true;
		} else {
			return false;
		}
	}
	
	// Consultar las peliculas de un director
	public Catalogo consultarPeliculasDirector(String director) {
		//definimos un objeto de Catalogo que sera lo que devolveremos y la longitud del contador porq asi no recorre huecos vacios
		Catalogo catalogoPeliDirector = new Catalogo(vecVideo.length);
		//recorreomos el vector de la clase PADRE creando un objeto de la clase padre,
		for (int pos = 0; pos < contador; pos++) {
			//a este objeto de la clase padre le instanciamos el vector en la pos que estanis recorriendo
			Video video = vecVideo[pos];
			//ahora comprobamos si el objeto de la clase padre esta instanciada en la clase que queremos usar en este caso PElicula
			if (video instanceof Pelicula) {
				//esto nos devuelve true si esta en la clase pelicula, false si no lo esta y null si no existe
				/*ahora como sabemos que el objeto video esta instanciado en una clase pelicula tranformamos 
				el objeto video a un objeto de pelicula para poder usar el getter o setter de esta pelicula y podemos asi saber sus datos*/
				Pelicula pelicula = (Pelicula)video;
				//comparamos con un equals(ya que comparamos String) el director que hemos pasado y con un get el director de pelicula
				if (director.equals(pelicula.getDirector())) {
					catalogoPeliDirector.insertar(video);
				}
			}
		}

		return catalogoPeliDirector;
	}
	
	//consulta las series por año de creacion 
	public Catalogo consultarSerieCreacion (int añoCreacion) {
		Catalogo catalogoSerieAñoCreacion = new Catalogo(vecVideo.length);
		for (int pos = 0; pos < contador ; pos++) {
			Video video = vecVideo[pos];
			if(video instanceof Serie) {
				Serie serie = (Serie) video;
				if(añoCreacion == serie.inicioEmision) {
					catalogoSerieAñoCreacion.insertar(serie);
				}
			}
		}
		return catalogoSerieAñoCreacion;
	}
	/*usamos estos metodos. El primera es para ver si hay un video en la posicion del cosigo
	 y reutilizamos el metodo eliminarPorPosicion para no crear otro, le enviamos la posicion del codigo y asi lo elimina */
	public int obtenerPosicion(int codigo) {
		for (int pos = 0; pos < contador ; pos++) {
			Video video = vecVideo[pos];
			if(video.getCodigo() == codigo) {
				return pos;
			}
		}
		return -1;
		//este menos unos quiere decir que devuelva que no encontro ningun codigo, por eso le da un 
		//numero negativo
	}
	public boolean eliminarPorPosicion(int pos) {
		boolean eliminado = false;
		if(pos >= 0 && pos < contador) {
			while(pos < contador -1 ) {
				vecVideo[pos] = vecVideo[pos +1];
				pos ++;
			}
			eliminado = true;
		}
		vecVideo[pos] = null;
		contador++;
		return eliminado;
	}
	
	//devuelve un catalogo donde estan primero las peliculas luego las series
	public Catalogo reorganizar() {
		Catalogo catalogoReorganizado = new Catalogo(vecVideo.length);
		for (int pos = 0; pos < contador ; pos++) {
			Video video = vecVideo[pos];
			if(video instanceof Pelicula) {
			catalogoReorganizado.insertar(video);	
			}
		}
		for (int pos = 0; pos < contador ; pos++) {
			Video video = vecVideo[pos];
			if(video instanceof Serie) {
			catalogoReorganizado.insertar(video);	
			}
		}
		return catalogoReorganizado;
	}

}
