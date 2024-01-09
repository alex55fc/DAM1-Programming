package Ejemp_Album_01;

import entrada.Teclado;

public class Principal {
	public static void escribirMenu () {
		System.out.println();
		System.out.println("(0) Para salir");
		System.out.println("(1) Insertar un album en la coleccion");
		System.out.println("(2) Consultar todos los albumes");
		System.out.println("(3) Eliminar un album, por posicion");
		System.out.println("(4) Consultar un album completo por posicion");
		System.out.println("(5) Consultar un album, por nombre de la coleccion.");
		System.out.println();

		
	}

	public static void main(String[] args) {
		int opcion;
		//declaramos un objeto de la clase coleccion
		Coleccion coleccion1 = new Coleccion(10);
		String nombre, artista, genero;
		int agnoPublicacion;
		
		//creamos un objero de la clase album
		Album album1;
		//casos donde necesitamos una posicon
		int posicion;
		do {
			escribirMenu();
			opcion = Teclado.leerEntero("Elige una opcion");
			switch(opcion) {
				//salir programa
			case 0:
				break;
				
				//Insertar album en la coleccion
			case 1:
				nombre = Teclado.leerCadena("Escribe el nombre: ");
				artista = Teclado.leerCadena("Escribe el artista: ");
				agnoPublicacion = Teclado.leerEntero("Escribe el año de publicacion: ");
				genero = Teclado.leerCadena("Escribe el genero: ");
				//aqui lo instanciamos 
				album1 = new Album(nombre , artista, agnoPublicacion, genero);
				
				if (coleccion1.insertar(album1)) {
					System.out.println("Se inserto 1 album correctamens");
				}
				else {
					System.out.println("Error al insertar: la coleccion esta llena.");
				}
				break;
				
			case 2:
				System.out.println(coleccion1.toString());
				break;
//--------------------------------------------------------------------------------------------------------------------------------	
			case 3:
				posicion = Teclado.leerEntero("¿Elimina un album por posicion?");
				if (coleccion1.eliminar(posicion)) {
					System.out.println("Se ha eliminado correctacmente el album en posicion "+ posicion);
				}
				else {
					System.out.println("Error al eliminar : la posicion esta vacio o la posicion es invalida.");
				}
				break;
//---------------------------------------------------------------------------------------------------------------------------------
				//consultar un album por posicoin de la coleccion
			case 4:
				posicion = Teclado.leerEntero("¿Consulta un album por posicion?");
				album1 = coleccion1.consulta(posicion);
				
				if(album1 == null) {
					System.out.println("No se ha encontrado ningun album en esa posicon");
					System.out.println("-la posicion es invalida o la coleccion esta vacia");
				}
				else {
					System.out.println(album1.toString());
				}
				break;
//--------------------------------------------------------------------------------------------------------------------------------
				//Consultar un album, por nombre de la coleccion.
			case 5: // usamos nombre ya que eya esta inicializado al inicio del programa
				nombre = Teclado.leerCadena("¿Nombre? ");
				album1 = coleccion1.consultarPorNombre(nombre);
				if(album1 == null) {
					System.out.println("No se ha encontrado ningun album con este nombre");
				}
				else {
					System.out.println(album1.toString());
				}
				break;
//---------------------------------------------------------------------------------------------------------------------------------
				//opcion no valida
			default:
				System.out.println("Elige una opcion entre 0-5");
				break;
			}
			
		}while(opcion != 0);
		System.out.println("Programa finalizado sin errores.");

	}

}
