package Ejer_practico;

import entrada.Teclado;

public class Principal {
	public static void escribirMenu() {
		System.out.println();
		System.out.println("(0) salir ");
		System.out.println("(1) Insertar una pelicula");
		System.out.println("(2) Insertar una serie ");
		System.out.println("(3) Consultar todos los videos ");
		System.out.println("(4) Consultar las peliculas de un director");
		System.out.println("(5) Consultar las series por año de inicio de emision ");
		System.out.println("(6) Eliminar un video por codigo");
		System.out.println("(7) Reorganizar el catalogo de forma que primero esten las pelicula y luego las series");
		System.out.println();
	}

	public static void main(String[] args) {
	int opcion;
	//porque instanciamos un catalogo?
	Catalogo catalogo = new Catalogo(10);
	//opcion 1
	String titulo, director;
	int añoCreacion;
	Pelicula pelicula;
	//opcion 2
	 int inicioEmision,finEmision,numTemporadas, numCapitulos;
	 Serie serie;
	 //opcion 3, uso director que ya instancie anteriormente 
	 Catalogo catalogoAux;
	 //opcion 4
	 int pos;
	 int codigo;
	do {
		escribirMenu();
		opcion = Teclado.leerEntero("¿opcion?");
		
		switch(opcion) {
		case 0:
			break;
//-----------------------------------------------------------
		case 1:
			//porque podemos poner el titulo aunque sea una 
			titulo = Teclado.leerCadena("nombre ");
			añoCreacion = Teclado.leerEntero("añp de creacion");
			director = Teclado.leerCadena("director ");
			pelicula = new Pelicula(titulo, añoCreacion, director);
			
			if(catalogo.insertar(pelicula)) {
				System.out.println("se ha ingresdo una pelicula correctamentes");
			}
			else {
				System.out.println("el vector esta lleno");
			}
			break;
//-----------------------------------------------------------
		case 2:
			titulo = Teclado.leerCadena("nombre ");
			inicioEmision = Teclado.leerEntero("año inicio emision ");
			finEmision = Teclado.leerEntero("año fin de emision ");
			numTemporadas = Teclado.leerEntero("numero temporadas");
			numCapitulos = Teclado.leerEntero("numero de capitulos ");
			serie = new Serie(titulo, inicioEmision,finEmision, numTemporadas, numCapitulos);
			if(catalogo.insertar(serie)) {
				System.out.println("se ha ingresdo una Serie correctamentes");
			}
			else {
				System.out.println("el vector esta lleno");
			}
			break;
//-----------------------------------------------------------
		case 3:
			if (catalogo.estaVacio()) {
				System.out.println("Esta vacio");
			}
			else {
				System.out.println(catalogo.toString());
				System.out.println(catalogo.obtenerNumVideosGuardados());
			}
			break;
//-----------------------------------------------------------
		case 4:
			director = Teclado.leerCadena("Director del que quiere consultar las peliculas? ");
			catalogoAux = catalogo.consultarPeliculasDirector(director);
			if (catalogoAux.estaVacio()) {
				System.out.println("No hay ninguna pelicula de ese director");
			}
			else {
				System.out.println(catalogoAux.toString());
				System.out.println(catalogoAux.obtenerNumVideosGuardados());
			}
			break;
//-----------------------------------------------------------
		case 5:
			añoCreacion = Teclado.leerEntero("Año de creacion de las series a consultar");
			catalogoAux = catalogo.consultarSerieCreacion(añoCreacion);
			if (catalogoAux.estaVacio()) {
				System.out.println("No hay ninguna serie que empiece en ese año de creacion");	
			}
			else {
				System.out.println(catalogoAux.toString());
				System.out.println(catalogoAux.obtenerNumVideosGuardados());
			}
			break;
//-----------------------------------------------------------
		case 6:
			codigo = Teclado.leerEntero("¿codigo?");
			pos = catalogo.obtenerPosicion(codigo);
			if(catalogo.eliminarPorPosicion(pos)) {
				System.out.println("se elimino el video correctamente");
			}
			else {
				System.out.println("video no encontrado en el catalogo");
			}
			break;
//-----------------------------------------------------------
		case 7:
			catalogoAux = catalogo.reorganizar();
			if (catalogoAux.estaVacio()) {
				System.out.println("Catalogo vacio");
			}
			else {
				System.out.println(catalogoAux.toString());
				System.out.println(catalogoAux.obtenerNumVideosGuardados());
			}
			break;
//-----------------------------------------------------------
		default:
			System.out.println("selecciona una oopcion correcta.");
			break;
		}
	}while(opcion != 0);
	
	}
}
