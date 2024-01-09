package Ejer_2_03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Libreria {
	//atributos
	private String nombre;
	private List<Libro> listaLibros;

	//crea una libreria a partir de 1 parametro 
	public Libreria (String nombre) {
		this.nombre = nombre;
		this.listaLibros = new ArrayList<Libro>();
	}

	@Override 
	public String toString() {
		String cadena = "LIBRERIA " + nombre + " " ;
		if(listaLibros.isEmpty()) {
			System.out.println("La libreria esta vacia.");
		}
		else {
			for(int pos = 0 ; pos < listaLibros.size(); pos++) {
				Libro libro = listaLibros.get(pos);
				cadena = cadena + "("+pos+")"+ libro.toString()	+ "\n";
			}
			cadena = cadena + "Libros consultados"+ listaLibros.size();
		}
		return cadena;
	}
	// aqui dos versiones de consultar 
	public Libro consultar (String isbn) {
		Libro libro = null;
		Libro libroBuscar = new Libro(isbn);//en Libro hay un constructor con solo parametro isbn
		int pos = listaLibros.indexOf(libroBuscar);
		if (pos != -1) {
			libro = listaLibros.get(pos);
		}
		return libro;
	}

	public Libro consultar2(String isbn) {
		for (Libro librox : listaLibros) {
			if(librox.getIsbn().equals(isbn)) {
				return librox;
			}
		}
		return null;
	}
	//insertar un libro en la libreria
	//usamos el add de listas para insertar
	public boolean insertar(Libro libro) {
		return listaLibros.add(libro);
	}

	//eliminamos un libro de la libreria
	//usamos el remove de listas 
	public boolean eliminar(String isbn) {
		Libro libroBuscar = new Libro (isbn);
		return listaLibros.remove(libroBuscar);
	}

	//
	public List<Libro> ordenarPorPrecioDesc() {
		List<Libro> listaLibroAux = new ArrayList<>();
		listaLibroAux.addAll(listaLibros);
		Collections.sort(listaLibroAux,new OrdenLibrosPorPrecioDesc());//usamos esta clase ya hecha anteriormente

		return listaLibroAux;
	}
	//consultar por escritor 
	//devolveremos una lista de libros con el nombre del escritor
	/*creamos una lista auxiliar que sera la que d*/
	public List<Libro> consultarPorEscritor (String escritor){
		List<Libro> listaLibrosAux  = new ArrayList<>();
		for (Libro libro : listaLibros) {
			if(libro.getEscritor().equalsIgnoreCase(escritor)) {
				listaLibrosAux.add(libro);
			}
		}
		return listaLibrosAux;
	}

	//devuleve una lista con los ilbros que tengan el precio maximo 
	/*primero comparamos los precios hasta sacar el mayor y luego comparamos los precios de los libros
	 * vemos sio el precio es igual al precioMaximo y lo guardamos en una lista auxiliar */
	public List<Libro> consultarPorPrecioMaximo(){
		double precioMaximo = 0.0;
		for (Libro libro : listaLibros) {
			if (libro.getPrecio() > precioMaximo) {
				precioMaximo = libro.getPrecio();
			}
		}
		List<Libro> listaLibrosAux = new ArrayList<>();
		for (Libro libro : listaLibros) {
			if(libro.getPrecio() == precioMaximo) {
				listaLibrosAux.add(libro);
			}
		}
		return listaLibrosAux;
	}
	
	//devolvemos un entero y no un booleano ya que hay mas de 2 casos 
	//
	public int vendedorPorIsbn(String isbn) {
		Libro libro = this.consultar2(isbn);
		
		if(libro == null) {
			return -1;//libro no econtrado
		}
		else {
			libro.decrementarNumeroUnidades();
			if (libro.getStock() > 0) {
				return 0; //libro vendido y quedan mas unidades 
			}
			else {
				this.eliminar(isbn);
				return 1;//si stock es 0 eliminamos el libro, con un metodo ya hecho,ya que no hay stock
			}
		}
	}



}
