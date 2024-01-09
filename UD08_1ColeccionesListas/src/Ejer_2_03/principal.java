package Ejer_2_03;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import entrada.Teclado;

public class principal {
	public static void escribirMenu() {
		System.out.println();
		System.out.println("(0) Salir del programa");
		System.out.println("(1) Insertar un libro en la lista");
		System.out.println("(2) Eliminar un libro, por ISBN");
		System.out.println("(3) Consultar un libro por ISBN");
		System.out.println("(4) Consultar todos los libros de la lista ");
		System.out.println("(5) Consultar todos los libros de la lista, en orden por precio descendente.");
		System.out.println("(6) Consultar varios libros, por escritor, de la lista");
		System.out.println();
	}
	public static void escribirLista(List<Libro> lista) {
		//con este bucle for each recorro la lista posicion a posicion 
		for(Libro x : lista ) {
			System.out.println(x.toString());
		}
		System.out.println(lista.size() + " libros consultados");
	}

	public static void main(String[] args) {
		int opcion;
		//creamos la lista 
		List <Libro> lista = new ArrayList<>();
		//creamos una lista auxiliar
		List <Libro> listaAux;
		//creamos un libro para poder insertar
		Libro libro;
		//caso 1
		 String isbn, titulo, escritor;
		 int añoPublicacion, stock;
		 double precio;
		do {
			escribirMenu();
			opcion = Teclado.leerEntero("opcion: ");
			switch(opcion) {
			case 0:
				break;
				//--------
			case 1:
				/*isbn = Teclado.leerCadena("isbn?");
				 * encontrado = false;
				 * for (int i = 0 ; i < listaLibros.size() ; i++){
				 * Libro lib = listaLibros.get(i)
				 * if (lib.getIsbn().equals(isbn){
				 * 	syso("Ya existe..");
				 * } 
				 * } */				
				isbn = Teclado.leerCadena("isbn?");
				libro = new Libro (isbn,"", "", 0,0,0);
				if (lista.contains(libro)) {//para usar bien el contains debemos usar hash code
					System.out.println("Ya existe otro libro con ese ISBN ");
				}
				else {
					titulo = Teclado.leerCadena("Titulo: ");
					escritor = Teclado.leerCadena("Escritor :");
					añoPublicacion = Teclado.leerEntero("Año de creacion: ");
					stock = Teclado.leerEntero("Stock: ");
					precio = Teclado.leerReal("Precio: ");
					
					libro = new Libro (isbn, titulo, escritor, añoPublicacion, stock, precio);
					if (lista.add(libro)) {
						System.out.println("Se ha insertado un libro en la lista");
					}
				}
				break;
				//--------
			case 2:
				//Eliminar un libro, por ISBN
				isbn = Teclado.leerCadena("Isbn del libro a borrar");
				libro = new Libro (isbn, "", "", 0, 0, 0);
				if (lista.remove(libro)) {
					System.out.println("Se ha eliminado");
				}
				else {
					System.out.println("no se ha encontrado ningun libro con ese ISBN");
				}
				break;
				//--------
			case 3:
				/*isbn = Teclado.leerCadena("Isbn del libro a consultar");
				 *libro = new Libro (isbn, "", "", 0, 0, 0);
				 *int posicion = listaLibros.indexOf(libro); indexOf busca la posicion del libro con el ISBN
				 *if (posicion != -1){
				 *libro = listaLibros.get(posicion);
				 *syso(libro.toString());
				 *}
				 *else{syso("No existe ningun libro con ese ISBN")} */
				
				//Consultar un libro por ISBN
				isbn = Teclado.leerCadena("Isbn del libro a consultar");
				libro = new Libro (isbn, "", "", 0, 0, 0);
				for (Libro x : lista) {
					if (x.getIsbn().equals(isbn)) {
						System.out.println(x.toString());
					}
					else {
						System.out.println("No hay ningun libro con ese ISBN");
					}
				}
				break;
				//--------
			case 4://Consultar todos los libros de la lista
				if (lista.isEmpty()) {
					System.out.println("La lista esta vacia");
				}
				else {
					escribirLista(lista);
				}
				break;
				//--------
			case 5:
				//Consultar todos los libros de la lista
				Collections.sort(lista, new OrdenLibrosPorPrecioDesc());
				escribirLista(lista);
				break;
				//--------
			case 6:
				
				
				
				
				
				
				
				
				
				
				
				/* escritor = Teclado.leerCadena("escritor");
				int contLibros = 0;
				for (int pos = 0; pos < lista.size(); pos++) {
					libro = lista.get(pos);
					if (libro.getEscritor().equalsIgnoreCase(escritor)) {
						System.out.println(libro.toString());
						contLibros++;
					}
				}
				if (contLibros == 0) {
					System.out.println("no existe ningun libro con ese escritor");
				}
				else {
					System.out.println("Se han consultado " +contLibros+ " libros en total" );
				}
				*/
				break;
				//--------
			default:
				System.out.println("Escoge eleccion correcta");
				break;
				//--------	
				
			}
		}while(opcion != 0);
	}

}
