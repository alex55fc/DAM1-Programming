package Ejer_usuario;

import java.util.ArrayList;
import java.util.List;

import entrada.Teclado;

public class principal {
	public static void escribirMenu() {
		System.out.println();
		System.out.println("(0) salir ");
		System.out.println("(-1) Insertar un producto en la lista de favoritos de un COmprador");
		System.out.println("(1) Insertar un administrador en la colección.");
		System.out.println("(2) Insertar un comprador en la colección.");
		System.out.println("(3) Consultar todos los usuarios de la colección.");
		System.out.println("(4) Consultar un usuario, por correo, de la colección.");
		System.out.println("(5) Actualizar el nombre y la contraseña de un usuario, por correo, de la colección.");
		System.out.println("(6) Eliminar un usuario, por correo, de la colección.");
		System.out.println("(7) Consultar todos los usuarios de la colección, ordenados por nombre ascendente.");
		System.out.println("(8) Consultar los usuarios que tengan una contraseña débil (6 o menos caracteres), de la colección.");
		System.out.println("(9) Consultar los compradores de la colección.");
		System.out.println("(10) Consultar los compradores que incluyan una ciudad en la dirección de envío, de la colección.");
		System.out.println("(11) Consultar los compradores con la lista de productos favoritos más larga de la colección.");
		System.out.println("(12) Consultar los administradores de la colección.");
		System.out.println("(13) Consultar los administradores de una categoría, de la colección.");
		System.out.println("(14) Consultar los administradores que no revisan comentarios, de la colección");
		System.out.println("(15) Añadir un producto a la lista de favoritos de un comprador, por correo, de la colección.");
		System.out.println("(16) Quitar un producto de la lista de favoritos de un comprador, por correo, de la colección.");
		System.out.println();

	}

	public static void escribirListaLibros(List<Usuario> listaUsuario ) {
		for (int pos = 0; pos < listaUsuario.size(); pos++) {
			Usuario usuario = listaUsuario.get(pos);
			System.out.println("("+pos+")" + usuario.toString());
		}
		System.out.println("Se han consultado "+ listaUsuario.size()+ " usuarios en la gestion de usuarios");
	}
	public static void main(String[] args) {
		int opcion;
		Usuario usuario;
		//Como no tengo nombre inicio la gestionde usuarios asi?
		gestionUsuarios gestion = new gestionUsuarios();
		//usuaario
		String correo, nombre, contrasenia;
		//caso -1 
		Comprador comprador;
		//caso 1
		String categoria;
		boolean revisaComentario;
		//caso 2
		String tarjetaPago, direccion;
		//caso 7
		//caso13
		List<Usuario> listaAux;
		//caso 16
		int num;
		do {
			escribirMenu();
			opcion = Teclado.leerEntero("opcion? ");
			switch (opcion) {
			case 0:
				break;
			case -1:
				listaAux = gestion.consultarComprador();
				if (listaAux.isEmpty()) {
					System.out.println("No hay ningun usuario Comprador");
				}
				else {
					nombre = Teclado.leerCadena("Nombre del producto: ");
				}
				break;
				//---------------
			case 1:
				//Insertar un administrador en la colección
				correo =Teclado.leerCadena("Correo del administrador?");
				usuario = gestion.consultar(correo);

				if(usuario == null) {
					nombre = Teclado.leerCadena("Nombre: ");
					contrasenia = Teclado.leerCadena("Contrasenia: ");
					categoria = Teclado.leerCadena("Ctegoria :");
					revisaComentario = Teclado.leerBooleano("Revisa comentarios");
					usuario = new Administradores(correo, nombre, contrasenia, categoria, revisaComentario);
					if (gestion.insertarUsuario(usuario)) {
						System.out.println("Se ha insertado un administrado");
					}
					else {
						System.out.println("no se pudo insertarcorrectamente");
					}
				}
				else {
					System.out.println("Usuario encontrado con ese correo");
				}
				break;
				//---------------
			case 2:
				//Insertar un comprador en la colección
				correo =Teclado.leerCadena("Correo  del comprador?");
				usuario = gestion.consultar(correo);

				if(usuario != null) {
					System.out.println("ya esxite un usario con esa contraseña");
				}
				else {
					nombre = Teclado.leerCadena("Nombre: ");
					contrasenia = Teclado.leerCadena("Contrasenia: ");
					tarjetaPago = Teclado.leerCadena("Trajeta de pago ");
					direccion =  Teclado.leerCadena("Direccion ");
					usuario = new Comprador(correo, nombre, contrasenia, tarjetaPago,direccion);
					if (gestion.insertarUsuario(usuario)) {
						System.out.println("Se ha insertado un comprador");
					}
					else {
						System.out.println("no se pudo insertarcorrectamente");
					}
				}
				break;
				//---------------
			case 3:
				//Consultar todos los usuarios de la colección.
				System.out.println(gestion.toString());
				break;
				//---------------
			case 4:
				//Consultar un usuario, por correo, de la colección.
				correo = Teclado.leerCadena("Correo?");
				usuario = gestion.consultar(correo);

				if (usuario == null) {
					System.out.println("No se encontro ningun usuario con ese correo");
				}
				else {
					System.out.println(usuario.toString());
				}
				break;
				//---------------
			case 5:
				//Actualizar el nombre y la contraseña de un usuario, por correo, de la colección.
				correo = Teclado.leerCadena("Correo?");
				usuario = gestion.consultar(correo);
				if (usuario == null) {
					System.out.println("No se encontro ningun usuario con ese correo");
				}
				else {
					nombre = Teclado.leerCadena("Nuevo nombre ");
					contrasenia = Teclado.leerCadena("Nueva contraseña ");

					gestion.cambiarNombContra(nombre, contrasenia, usuario);
					System.out.println("Se han cambiado los datos");
					System.out.println(usuario.toString());
				}
				break;
				//---------------
			case 6:
				//Eliminar un usuario, por correo, de la colección.
				correo = Teclado.leerCadena("Correo?");
				usuario = gestion.consultar(correo);
				if (usuario == null) {
					System.out.println("No se encontro ningun usuario con ese correo");
				}
				else {
					if (gestion.elminarUsuario(usuario)) {
						System.out.println("Seha eliminado el usuario "+usuario);
					}
					else {
						System.out.println("No se pudoeliminar el  usuario");
					}
				}
				break;
				//---------------
			case 7:
				listaAux = gestion.ordenarPorNombreAsc();
				if (listaAux.isEmpty()) {
					System.out.println("Coleccion vacia");
				}
				else {
					escribirListaLibros(listaAux);
				}

				break;
				//---------------
			case 8:
				//Consultar los usuarios que tengan una contraseña débil (6 o menos caracteres), de la colección
				listaAux = gestion.contraDebil();
				if (listaAux.isEmpty()) {
					System.out.println("No hay contraseñas debbiles 6 caracteres o menos");
				}
				else {
					escribirListaLibros(listaAux);
				}

				break;
				//---------------
			case 9:
				//Consultar los compradores de la colección
				listaAux = gestion.consultarComprador();
				if (listaAux.isEmpty()) {
					System.out.println("No hay ningun usuario");
				}
				else {
					escribirListaLibros(listaAux);
				}
				break;
				//---------------
			case 10:
				// Consultar los compradores que incluyan una ciudad en la dirección de envío, de la colección
				listaAux = gestion.consultarComprador();
				if (listaAux.isEmpty()) {
					System.out.println("No hay ningun usuario");
				}
				else {
					direccion = Teclado.leerCadena("ciudad ");
					listaAux = gestion.ciudadComprador(direccion);
					if (listaAux.isEmpty()) {
						System.out.println("No hay compradores en esa ciudad");
					}
					else {
						escribirListaLibros(listaAux);
					}
				}
				break;
				//---------------
			case 11:
				listaAux = gestion.consultarCompradorPorTamanioLista();
				if(listaAux.isEmpty()) {
					System.out.println("No hay compradores");
				}
				else {
					escribirListaLibros(listaAux);
				}
				break;
				//---------------
			case 12:
				// Consultar los administradores de la colección
				listaAux =  gestion.consultarAdministradores();
				if (listaAux.isEmpty()) {
					System.out.println("La lista esta vacia");
				}
				else {
					escribirListaLibros(listaAux);
				}
				break;
				//---------------
			case 13:
				//Consultar los administradores de una categoría, de la colección
				listaAux =  gestion.consultarAdministradores();
				if (listaAux.isEmpty()) {
					System.out.println("No hay administradore");
				}
				else {
					categoria =Teclado.leerCadena("Categoria de compradores");
					listaAux = gestion.consultarAdminCategoria(categoria);
					if(listaAux.isEmpty()) {
						System.out.println("No hay ningun admin con esa categoria");
					}
					else {
						escribirListaLibros(listaAux);
					}
				}
				break;
				//---------------
			case 14:
				
				break;
				//---------------
			case 15:
				//Añadir un producto a la lista de favoritos de un comprador, por correo, de la colección.
				correo = Teclado.leerCadena("Correo ");
				usuario = gestion.consultar(correo);
				if (usuario == null) {
					System.out.println("No hay ningun usuario con ese correo.");
				}
				//CONVERTIMOS EL USUARIO A UN COMPRADOR PARA PODER USAR EL METODO DE COMPRAADOR
				else if (usuario instanceof Comprador){
					nombre = Teclado.leerCadena("nombre Producto ");
					comprador = (Comprador) usuario;
					if(comprador.insertarFavorito(nombre)) {
						System.out.println("Se ha insertao un prodcuto a la lista de favoritos ");
					}
					else {
						System.out.println("No se ha podido insertar el producto");
					}
				}
				else {
					System.out.println("El usuario no es un comprador");
				}
				break;
				//----
			case 16:
				//Quitar un producto de la lista de favoritos de un comprador, por correo, de la colección.
				correo = Teclado.leerCadena("Correo");
				usuario = gestion.consultar(correo);
				
				if (usuario ==null) {
					System.out.println("No hay ningun usuario con ese correo ");
				}
				else if (usuario instanceof Comprador){
					/*
					 * por nombre
					nombre = Teclado.leerCadena("nombre Producto ");
					comprador = (Comprador) usuario;
					if(comprador.eliminarNombre(nombre)) {
						System.out.println("Se ha elimando un prodcuto a la lista de favoritos ");
					}*/
					num = Teclado.leerEntero("numero dep osicion");
					comprador = (Comprador) usuario;
					if(comprador.eliminarNombre(num)) {
						System.out.println("Seha elimniado por posicion ");
					}
					else {
						System.out.println("No se ha podido eliminar el producto");
					}
				}
				else {
					System.out.println("El usuario no es un comprador");
				}
				break;
			}

		}while (opcion != 0);

	}

}
