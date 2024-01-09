package cositas_01;

import entrada.Teclado;

public class Ejer_1_01_Videojuego {

	public static void main(String[] args) {

		String nombre, desarrollador;
		int agno, numeroMaximoJugadores;

		System.out.println("VIDEOJUEGO 1");
		
		nombre = Teclado.leerCadena("introduce nombre: ");
		desarrollador =Teclado.leerCadena("Introduce desarrolador: ");
		agno = Teclado.leerNatural("Introduce año: ");
		numeroMaximoJugadores = Teclado.leerNatural("Introduce máximo de jugadores: ");

		// introducimos la clase y introducimos videojeugo1, ponemos en orden los constructores del otro porgrama
		Videojuego videojuego1 = new Videojuego(nombre, desarrollador, agno, numeroMaximoJugadores);
		System.out.println(videojuego1.obtenerEstado());
		

		System.out.println("VIDEOJUEGO 2");
		
		nombre = Teclado.leerCadena("introduce nombre: ");
		desarrollador =Teclado.leerCadena("Introduce desarrolador: ");
		agno = Teclado.leerNatural("Introduce año: ");

		Videojuego videojuego2 = new Videojuego(nombre, desarrollador, agno);
		System.out.println(videojuego2.obtenerEstado());


		System.out.println("VIDEOJUEGO 3");
		
		nombre = Teclado.leerCadena("introduce nombre: ");
		desarrollador =Teclado.leerCadena("Introduce desarrolador: ");
	
		Videojuego videojuego3 = new Videojuego(nombre, desarrollador);
		System.out.println(videojuego3.obtenerEstado());

	}

}
