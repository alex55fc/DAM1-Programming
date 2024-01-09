package Ejer_usuario_prof;
import java.util.List;

import entrada.Teclado;

public class Principal {

	public static void escribirMenuOpciones() {
		System.out.println();
		System.out.println("(0) Salir del programa.");
		System.out.println("(1) Insertar un administrador en la colecci�n.");
		System.out.println("(2) Insertar un comprador en la colecci�n.");
		System.out.println("(7) Consultar todos los usuarios de la colecci�n, ordenados por nombre ascendente.");
		System.out.println("(10) Consultar los compradores que incluyan una ciudad en la direcci�n de env�o.");
		System.out.println("(11) Consultar los compradores con la lista de productos favoritos m�s larga");
		System.out.println("(15) A�adir un producto a la lista de favoritos de un comprador, por correo.");
		System.out.println();
	}
	
	public static void escribirLista(List<Usuario> lista) {
		if (lista.isEmpty()) {
			System.out.println("colecci�n vac�a");
		}
		else {
			for (Usuario usu : lista) {
				System.out.println(usu.toString());
			}
			System.out.println(lista.size() + 
								" usuarios consultados.");
		}
	}
	
	public static void main(String[] args) {
		Coleccion coleccion = new Coleccion(); // FUNDAMENTAL
		List<Usuario> listaAux;
		int opcion;
		String nombre, correo, contrasegna, categoria, tarjeta, direccion, ciudad, producto;
		boolean revisaComentarios;
		Usuario usuario;
		Comprador comprador;
		do {
			escribirMenuOpciones();
			opcion = Teclado.leerEntero("�Opci�n? ");
			switch (opcion) {
			// Salir del programa.
			case 0:
				break;
				
			// Insertar un administrador en la coleccion.
			case 1:
				correo = Teclado.leerCadena("�Correo? ");
				usuario = coleccion.consultarPorCorreo(correo);
				if (usuario == null) {
					nombre = Teclado.leerCadena("�Nombre? ");
					contrasegna = Teclado.leerCadena("�Contrase�a? ");
					categoria = Teclado.leerCadena("�Categor�a? ");
					revisaComentarios = Teclado.leerBooleano("�Revista Comentarios? ");
					usuario = new Administrador(nombre, correo, contrasegna,
							categoria, revisaComentarios);
					if (coleccion.insertar(usuario)) {
						System.out.println("Administrador insertado.");
					}
					else {
						System.out.println("Error al insertar.");
					}
				}
				else {
					System.out.println("Usuario encontrado con ese correo.");
				}
				break;
				
			// Insertar un comprador en la colecci�n.
			case 2:
				correo = Teclado.leerCadena("�Correo? ");
				usuario = coleccion.consultarPorCorreo(correo);
				if (usuario == null) {
					nombre = Teclado.leerCadena("�Nombre? ");
					contrasegna = Teclado.leerCadena("�Contrase�a? ");
					tarjeta = Teclado.leerCadena("�Tarjeta? ");
					direccion = Teclado.leerCadena("�Direcci�n? ");
					usuario = new Comprador(nombre, correo, contrasegna,
							tarjeta, direccion);
					if (coleccion.insertar(usuario)) {
						System.out.println("Comprador insertado.");
					}
					else {
						System.out.println("Error al insertar.");
					}
				}
				else {
					System.out.println("Usuario encontrado con ese correo.");
				}
				break;
				
			// Consultar todos los usuarios de la colecci�n, ordenados por nombre ascendente.
			case 7:
				listaAux = coleccion.ordenarPorNombreAsc();
				escribirLista(listaAux);
				break;
				
			// Consultar los compradores que incluyan una ciudad en la direcci�n de env�o
			case 10:
				ciudad = Teclado.leerCadena("�Ciudad? ");
				listaAux = coleccion.consultarCompradoresPorCiudad(ciudad);
				if (listaAux.isEmpty()) {
					System.out.println("No hay compradores con esa ciudad.");
				}
				else {
					escribirLista(listaAux);
				}
				break;
			
			// Consultar los compradores con la lista de productos favoritos m�s larga
			case 11:
				listaAux = coleccion.consultarCompradoresPorTamagnoLista();
				if (listaAux.isEmpty()) {
					System.out.println("No hay compradores.");
				}
				else {
					escribirLista(listaAux);
				}
				break;
				
			// A�adir un producto a la lista de favoritos de un comprador, por correo
			case 15:
				correo = Teclado.leerCadena("�Correo? ");
				usuario = coleccion.consultarPorCorreo(correo);
				if (usuario == null) {
					System.out.println("No hay ning�n usuario con ese correo.");
				}
				else if (usuario instanceof Comprador) {
					producto = Teclado.leerCadena("�Producto? ");
					comprador = (Comprador) usuario;
					if (comprador.insertar(producto)) {
						System.out.println("Producto a�adido a la lista del comprador");
					}
					else {
						System.out.println("Error al a�adir producto");
					}
				}
				else {
					System.out.println("El usuario no es un comprador.");
				}
				break;
			}
		}
		while (opcion != 0);
	}

}
