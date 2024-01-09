package Ejer_2_03;

import java.util.List;

import entrada.Teclado;

public class principal_parte2 {
	public static void escribirMenu() {
		System.out.println();
		System.out.println("(0) Salir del programa");
		System.out.println("(1) Crear nueva libreria");
		System.out.println("(2) Insertar libro en la libreria ");
		System.out.println("(3) Eliminar un libro, por ISBN, de la librería" );
		System.out.println("(4) Consultar un libro, por ISBN, de la librería. ");
		System.out.println("(5) Consultar todos los libros de la librería");
		System.out.println("(6) Consultar todos los libros de la librería, en orden por precio descendente");
		System.out.println("(7) Consultar varios libros, por escritor, de la librería.");
		System.out.println("(8) Consultar el libro de mayor precio de la librería.");
		System.out.println("(9) Gestionar la venta de una unidad de un determinado libro por ISBN");
		System.out.println();
	}
	public static void escribirListaLibros(List<Libro> listaLibros ) {
		for (int pos = 0; pos < listaLibros.size(); pos++) {
			Libro libro = listaLibros.get(pos);
			System.out.println("("+pos+")" + libro.toString());
		}
		System.out.println("Se han consultado"+ listaLibros.size()+ " libros de la libreria");
	}

	public static void main(String[] args) {
		int opcion;
		Libreria libreria = null; //es necesario el null
		Libro libro;
		//caso1
		String nombre;
		//caso 
		String isbn,titulo,escritor;
		int stock,añoPublicacion;
		double precio;
		//caso 6
		List<Libro> listaLibroAux;
		//caso 9
		int codigoVenta;
		do {
			escribirMenu();
			opcion = Teclado.leerEntero("opcion");
			switch(opcion) {
			case 0:
				break;
				//--
			case 1:
				//Crear nueva libreria
				nombre = Teclado.leerCadena("nombre");
				libreria = new Libreria(nombre);
				System.out.println("Se ha creado un anueva libreria ");
				break;
				//--
			case 2:
				//Insertar libro en la libreria
				if (libreria == null) {
					System.out.println("La libreria no esta creada");
				}
				else {
					isbn = Teclado.leerCadena("isbn? ");
					libro = libreria.consultar(isbn);
					if (libro != null) {
						System.out.println("Ya existe otro libro con ese ISBN");
					}
					else {
						titulo = Teclado.leerCadena("Titulo: ");
						escritor = Teclado.leerCadena("Escritor :");
						añoPublicacion = Teclado.leerEntero("Año de creacion: ");
						stock = Teclado.leerEntero("Stock: ");
						precio = Teclado.leerReal("Precio: ");

						libro = new Libro (isbn, titulo, escritor, añoPublicacion, stock, precio);
						if (libreria.insertar(libro)) {
							System.out.println("Se ha insertado un libro");
						}
						else {
							System.out.println("No se ha podido insertar");
						}
					}
				}
				break;
				//---
			case 3:
				//Eliminar un libro, por ISBN, de la librería
				if (libreria == null) {
					System.out.println("La libreria no esta creada");
				}
				else {
					isbn = Teclado.leerCadena("Isbn");
					if(libreria.eliminar(isbn)) {
						System.out.println("Se ha eliminado");
					}
					else {
						System.out.println("No se ha encontrado ningun libro");
					}
				}
				break;
			case 4:
				//Consultar un libro, por ISBN, de la librería.
				if (libreria == null) {
					System.out.println("La libreria no esta creada");
				}
				else {
					isbn = Teclado.leerCadena("isbn?");
					libro = libreria.consultar(isbn);
					if(libro == null) {
						System.out.println("No se ha encontrado ningun libro");
					}
					else {
						System.out.println(libro.toString());
					}
				}
				break;
			case 5:
				//Consultar todos los libros de la librería
				if (libreria == null) {
					System.out.println("Antes debes crear una libreria ");
				}
				else {
					System.out.println(libreria.toString());
				}
				break;
				//--
			case 6:
				//consultar todos los libros de la librería, en orden por precio descendente
				if (libreria == null) {
					System.out.println("Antes debes crear una libreria ");
				}
				else {
					listaLibroAux = libreria.ordenarPorPrecioDesc();
					System.out.println(listaLibroAux.toString());
				}
				break;
				//--
			case 7: 
				if (libreria == null) {
					System.out.println("Cre una libreria antes ");
				}
				else {
					escritor = Teclado.leerCadena("Escritor? ");
					listaLibroAux = libreria.consultarPorEscritor(escritor);
					if (listaLibroAux.isEmpty()) {
						System.out.println("WEsta vacia ");
					}
					else {
						escribirListaLibros(listaLibroAux);
					}

				}
				break ;
				//--
			case 8:
				if (libreria == null) {
					System.out.println("Antes crea una libreria ");
				}
				else {
					listaLibroAux=libreria.consultarPorPrecioMaximo();
					if (listaLibroAux.isEmpty()) {
						System.out.println("La libreria esta vacia");
					}
					else {
						escribirListaLibros(listaLibroAux);
					}
				}
				break;
				//--
			case 9:
				if (libreria == null) {
					System.out.println("Antes crea una libreria");
				}
				else {
					isbn = Teclado.leerCadena("Isbn? ");
					//en el parametro codigoVenta es donde devulve el resultado de vendedorPorIsbn y esos resultados devulven un dato depende del metodo
					//resultados posible -1, 0 y 1 eso lo pusimos en los metodos
					codigoVenta = libreria.vendedorPorIsbn(isbn);
					if (codigoVenta == -1) {
						System.out.println("No se ah encontrado ningun libro con ese ISBN");
					}	
					else if (codigoVenta == 0) {
						System.out.println("se ha vendido una unidad del libro con ese ISBN");
						System.out.println("Aun quedan mas unidades de ese libro en la lista");
					}
					else {
						System.out.println("Se ha vendido 1 unidad del libro con ese ISBN");
						System.out.println("No quedan mas unidades de ese libro en la lista ");
						System.out.println("Se ha eliminado ese libro de la libreria");
					}
					break;
				}
			}

		}while(opcion != 0);
	}
}

//subir el porcentaje de precios segun su nombre

