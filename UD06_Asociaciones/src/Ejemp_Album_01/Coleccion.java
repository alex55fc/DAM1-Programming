package Ejemp_Album_01;

public class Coleccion {
	//atributos
	// es un vector de objetos de la clase Album
	private Album[] vectorAlbumes;
	private int contadorAlbumes;//es el numero de álbumes guardados en el vector y tambien la primera posición libre del vector
	
	//constructor, crea una construccion vacía
	public Coleccion (int capacidad) { 
/* creamos el constructor con la capacidad que introduciremos futuramente, y esa es la 
capacidad del vector de albumes*/
		vectorAlbumes = new Album[capacidad];
		contadorAlbumes = 0;
	}
	
	
	//devuelve una cadena de caracteres con el estado de la coleccion 
	@Override
	public String toString() {
		String cadena = ""; // contadorALbumes, porque solo recorreremos el vector hasta las posiciones que tenga el vector
		
		if(contadorAlbumes == 0) {
			cadena = "La coleccion no tiene almbumes";
		}
		else {
			for (int pos = 0; pos < contadorAlbumes ; pos++) {
			Album x = vectorAlbumes[pos];   //este toString se refiere al toString de
			cadena = cadena + "("+ pos +")"+ x.toString() + "\n";
			}
	
		}
			return cadena;
	}
	
	
	// metodo que inserta un albúm en la coleccion
	public boolean insertar(Album x) {
		// este if: si el contador e albumes es menor que la capidad del vectorAlbumes es porq hay espacio para insertar 1
		if (contadorAlbumes < vectorAlbumes.length) {
			vectorAlbumes[contadorAlbumes] = x;
			contadorAlbumes++;
			return true;
		}
		else {
			return false;
		}
	}
	//metodo elimina un album, por posicion, de la coleccion.
	//devuelve verdadero si el album se ha eliminado, y falso si el vector esta vacio o la posicion este erronea
	public boolean eliminar(int posicion) {
		if(posicion < contadorAlbumes && posicion >= 0) {
			while (posicion < contadorAlbumes - 1) {
				vectorAlbumes[posicion] = vectorAlbumes[posicion +1];
				posicion++;
			}
			vectorAlbumes[posicion] = null;
			contadorAlbumes--;
			return true;
		}
		else {
			return false;
		}
	}
	
	//consulta un album, por posicion de la coleccion
	//de vuelve null si la posicion no es valida o si el vector vacio.
	public Album consulta(int pos) {
		if(pos < contadorAlbumes && pos >= 0) {
			return vectorAlbumes[pos];
		}
		else {
			return null;
		}
	}
	
	//consulta un album por nombre, de la coleccion
	//se supone que el nombre no esta repetido en la coleccion, no hay dos o mas albumes con el mismo nombre
	//devuelve null si no hay ningun album con el nombre dado.
	public Album consultarPorNombre(String nombre) {
		//este booleano 
		boolean encontrado = false;
		Album albumEncontrado = null;
		Album albumX;
		for (int pos = 0 ; pos < contadorAlbumes && !encontrado; pos++) {
			albumX = vectorAlbumes[pos];
			//para comprobar el contenido de dos cadenas usamos el metodo equals, si usamos el == comparamos la direccion no el contenido
			if(nombre.equals(albumX.getNombre()) ) {
				encontrado = true;
				albumEncontrado = albumX;
			}
		}
		return albumEncontrado;
	}
	
}
