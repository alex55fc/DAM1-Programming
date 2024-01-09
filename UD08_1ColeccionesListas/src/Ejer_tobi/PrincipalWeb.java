package Ejer_tobi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import entrada.Teclado;

public class PrincipalWeb {

	public static void escribirMenuOpciones() {
		System.out.println("------------------------------------------------------------------");
		System.out.println("(1) Insertar un administrador en la colección.\r\n"
				+ "(2) Insertar un comprador en la colección.\r\n"
				+ "(3) Consultar todos los usuarios de la colección.\r\n"
				+ "(4) Consultar un usuario, por correo, de la colección.\r\n"
				+ "(5) Actualizar el nombre y la contraseña de un usuario, por correo, de la colección.\r\n"
				+ "(6) Eliminar un usuario, por correo, de la colección.\r\n"
				+ "(7) Consultar todos los usuarios de la colección, ordenados por nombre ascendente.\r\n"
				+ "(8) Consultar los usuarios que tengan una contraseña débil (6 o menos caracteres), de la colección.\r\n"
				+ "(9) Consultar los compradores de la colección.\r\n"
				+ "(10) Consultar los compradores que incluyan una ciudad en la dirección de envío, de la colección.\r\n"
				+ "(11)Añadir un producto a la lista de favoritos de un comprador, por correo, de la colección.\r\n"
				+ "(12) Consultar los administradores de la colección.\r\n"
				+ "(13) Consultar los administradores de una categoría, de la colección.\r\n"
				+ "(14) Consultar los administradores que no revisan comentarios, de la colección.\r\n"
				+ "(15) Consultar los compradores con la lista de productos favoritos más larga de la colección.\r\n"
				+ "(16) Quitar un producto de la lista de favoritos de un comprador, por correo, de la colección.\r\n"
				+ "(17) Generar una contraseña segura a aquellos usuarios que tengan una contraseña debil.\r\n"
				);
		System.out.println("------------------------------------------------------------------");
	}


	public static void escribirLista(List<Usuario>lista) {
		if(lista.isEmpty()) {
			System.out.println("La lista esta vacia");
		}
		else {
			System.out.println(lista.toString());	
		}
	}

	//NO FUNCIONA, ARREGLAR
	public static boolean comprobarCategoria(List<Usuario>lista, String categoria) {
		if(lista.isEmpty()) {
			System.out.println("La lista esta vacia");
		}
		else {
			for(Usuario user : lista) {
				Administrador admin  = (Administrador)user;
				if (admin.getCategoria().equalsIgnoreCase(categoria)) {
					return true;
				}
			}
		}
		return false;
	}



	public static void main(String[] args) {
		List<Usuario> lista = new ArrayList <Usuario>();
		List<Usuario> listaUserAux;
		List<Usuario> listaContrasenia;
		List<Usuario> listaCiudad;
		List<Usuario> listaCategoria;
		List<Usuario> listaAdminsQueNoRevisan;
		String nombre, correo, contrasenia, categoria, tarjetaPago,
		direccion, producto;
		boolean revisar;
		int opcion;
		Administrador admin = null;
		Comprador comprador = null;
		Usuario user;
		Amazon tienda = new Amazon ("Amazon");
		do {
			escribirMenuOpciones();
			opcion = Teclado.leerEntero("Opcion (0-17)? ");
			switch (opcion) {
			// Salir del programa.
			case 0:
				break;
			case 1:
				nombre = Teclado.leerCadena("Nombre del administrador: ");
				correo = Teclado.leerCadena("Correo electronico: ");
				if(!correo.contains("@gmail.com")) {
					correo = correo + "@gmail.com";
				}
				contrasenia = Teclado.leerCadena("Contraseña: ");
				categoria = Teclado.leerCadena("Categoria: ");
				revisar = Teclado.leerBooleano("Revisa? ");
				admin = new Administrador (nombre, correo, contrasenia, categoria, revisar);
				lista.add(admin);
				if(tienda.insertar(admin)) {
					System.out.println("Se ha insertado un administrador");
				}
				else {
					System.out.println("Error al insertar");
				}
				break;
			case 2:
				nombre = Teclado.leerCadena("Nombre del comprador: ");
				correo = Teclado.leerCadena("Correo electronico: ");
				if(!correo.contains("@gmail.com")) {
					correo = correo + "@gmail.com";
				}
				contrasenia = Teclado.leerCadena("Contraseña: ");
				tarjetaPago = Teclado.leerCadena("Numero de tarjeta: ");
				direccion = Teclado.leerCadena("Direccion: ");
				comprador = new Comprador (nombre, correo, contrasenia, tarjetaPago, direccion);
				lista.add(comprador);
				if(tienda.insertar(comprador)) {
					System.out.println("Se ha insertado un comprador");
				}
				else {
					System.out.println("Error al insertar");
				}
				break;
			case 3:
				if(lista.isEmpty()) {
					System.out.println("La lista esta vacia");
				}
				else {
					System.out.println(tienda.toString());
				}
				break;
			case 4:
				if(lista.isEmpty()) {
					System.out.println("La lista esta vacia");
				}
				else {
					correo = Teclado.leerCadena("correo de usuario a buscar? ");
					user = tienda.consultarPorCorreo(correo);
					if (user == null) {
						System.out.println("No se ha encontrado ningun usuario con ese correo electronico");
					}
					else {
						System.out.println(user.toString());
					}
				}
				break;
			case 5:
				if(lista.isEmpty()) {
					System.out.println("La lista esta vacia");
				}
				else {
					correo = Teclado.leerCadena("correo de usuario a buscar? ");
					user = tienda.consultarPorCorreo(correo);
					if (user == null) {
						System.out.println("No se ha encontrado ningun usuario con ese correo electronico");
					}
					else {
						nombre = Teclado.leerCadena("Nuevo nombre: ");
						contrasenia = Teclado.leerCadena("Nueva contraseña: ");
						tienda.cambiarNombreyContrasenia(correo, nombre, contrasenia);
						System.out.println("Se ha actualizado el nombre y la contraseña");
					}

				}
				break;
			case 6:
				if(lista.isEmpty()) {
					System.out.println("La lista esta vacia");
				}
				else {
					correo = Teclado.leerCadena("correo de usuario a buscar? ");
					if(tienda.eliminarPorCorreo(correo)) {
						System.out.println("Se ha eliminado el usuario de correo: " + correo);
					}
					else {
						System.out.println("Error al eliminar, ningun usuario con ese correo.");
					}
				}
				break;
			case 7:
				if(lista.isEmpty()) {
					System.out.println("La lista esta vacia");
				}
				else {
					listaUserAux = new ArrayList<Usuario>();
					listaUserAux.addAll(lista);
					Collections.sort(listaUserAux, new OrdenarPorNombreAsc());
					if (listaUserAux.isEmpty()) {
						System.out.println("La lista está vacía.");
					}
					else {
						escribirLista(listaUserAux);
					}
				}
				break;
			case 8:
				if(lista.isEmpty()) {
					System.out.println("La lista esta vacia");
				}
				else {
					listaContrasenia = tienda.contraseniaDebil();
					if(listaContrasenia.isEmpty()) {
						System.out.println("No hay usuarios con contraseñas debiles.");
					}
					System.out.println("LISTADO DE USUARIOS CON CONTRASEÑAS DEBILES:");
					System.out.println(listaContrasenia.toString());
				}
				break;
			case 9:
				if(lista.isEmpty()) {
					System.out.println("La lista esta vacia");
				}
				else {
					System.out.println(comprador.toString());
				}
				break;
			case 10:
				System.out.println("COMPRADORES QUE TENGAN UNA CIUDAD EN LA DIRECCION: ");
				if(lista.isEmpty()) {
					System.out.println("La lista esta vacia");
				}
				else {
					listaCiudad = tienda.direccionConCiudad();
					if(listaCiudad.isEmpty()) {
						System.out.println("No hay usuarios que contangan ciudades en su direccion.");
					}
					else {
						System.out.println(listaCiudad.toString());
					}
				}
				break;
			case 11:
				if(lista.isEmpty()) {
					System.out.println("La lista esta vacia");
				}
				else {
					correo = Teclado.leerCadena("correo de usuario a para añadir producto: ");
					user = tienda.consultarPorCorreo(correo);
					if (user == null) {
						System.out.println("No se ha encontrado ningun usuario con ese correo electronico");
					}
					else {
						producto = Teclado.leerCadena("Producto a añadir: ");
						if(tienda.añadirProducto(correo,producto)) {
							System.out.println("Se ha añadido el producto: " + producto + " a la lista.");
						}
						else {
							System.out.println("Error al añadir.");
						}
					}
				}
				break;
			case 12:
				if(lista.isEmpty()) {
					System.out.println("La lista esta vacia");
				}
				else {
					System.out.println(admin.toString());
				}
				break;
			case 13:
				if(lista.isEmpty()) {
					System.out.println("La lista esta vacia");
				}
				else {
					categoria = Teclado.leerCadena("Categoria? ");
					listaCategoria = tienda.consultarAdminPorCategoria(categoria);
					if(listaCategoria.isEmpty()) {
						System.out.println("No hay administradores en esa categoria");
					}
					else {
						System.out.println(listaCategoria.toString());	
					}
				}
				break;
			case 14:
				if(lista.isEmpty()) {
					System.out.println("La lista esta vacia");
				}
				else {
					listaAdminsQueNoRevisan = tienda.adminsQueNoRevisan();
					if(listaAdminsQueNoRevisan.isEmpty()) {
						System.out.println("No hay ningun administrador que no revise");
					}
					else {
						System.out.println(listaAdminsQueNoRevisan.toString());
					}
				}
				break;
			case 15:
				if(lista.isEmpty()) {
					System.out.println("La lista esta vacia");
				}
				else {
					listaUserAux = tienda.listaMasLarga2();
					escribirLista(listaUserAux);
				}
				break;
			case 16:
				if(lista.isEmpty()) {
					System.out.println("La lista esta vacia");
				}
				else {
					correo = Teclado.leerCadena("correo de usuario a para eliminar producto: ");
					user = tienda.consultarPorCorreo(correo);
					if (user == null) {
						System.out.println("No se ha encontrado ningun usuario con ese correo electronico");
					}
					else {
						producto = Teclado.leerCadena("Producto a eliminar: ");
						if(tienda.eliminarProducto(correo,producto)) {
							System.out.println("Se ha eliminado el producto: " + producto + " de la lista.");
						}
						else {
							System.out.println("Error al eliminar.");
						}
					}

				}
				break;
			case 17:
				if(lista.isEmpty()) {
					System.out.println("La lista esta vacia");
				}
				else {
					listaContrasenia = tienda.contraseniaDebil();
					if(!listaContrasenia.isEmpty()) {
						if(tienda.cambiarContrasenia()) {
							System.out.println("Se ha actualizado la contraseña");
						}
					}
					else {
						System.out.println("Error, no hay ningun usuario con contraseña debil.");
					}
				}
				break;
			}






		}

		while (opcion != 0);



	}

}



