package cadena_caracteres_02;

import entrada.Teclado;

public class Ejer_2_08 {
	
	//cuenta y devuelve el numero de espacios en blanco de un texto
	public static int contarEspacios (String mensaje) {
		int contadorEspacios = 0;
		for (int posicion = 0 ; posicion < mensaje.length() ; posicion++) {
			char caracter = mensaje.charAt(posicion);
			if (caracter == ' ') {
				contadorEspacios++;
			}
		}
		return contadorEspacios;		
	}
	
	//leer un nombre completo que tenga un espacio en blanco 
	// no comience ni acabe con un espacio en blanco
	public static String leerNombreCompletoConDosPalabras(String mensaje) {
		String nombreCompleto = Teclado.leerCadena(mensaje);
		int contadorEspacios = contarEspacios(nombreCompleto);
		
// ojo que startswith y endswith lee String no caracteres, por eso ponemos el espacio en blanco en comillas"" no en comas simples''
		while (contadorEspacios != 1 || nombreCompleto.startsWith(" ") || nombreCompleto.endsWith(" ")) {
			System.out.println("El nombre completo debe terner un espacio en blanco ");
			System.out.println("El nombre completo no debe empezar en un espacio en blanco ");
			System.out.println("El nombre completo no debe terminar en  un espacio en blanco ");
			nombreCompleto = Teclado.leerCadena(mensaje);
			contadorEspacios = contarEspacios(nombreCompleto);
		}
		return nombreCompleto;	
	}

	public static void main(String[] args) {
		String nombreCompleto1 = leerNombreCompletoConDosPalabras("¿Nombre completo 1? ");
		String nombreCompleto2 = leerNombreCompletoConDosPalabras("¿Nombre completo 2? ");
		
		// usaremos indexof ' ' para buscar el espacio en blanco
		int posicionEspacio1 = nombreCompleto1.indexOf(' ');
		
		// luego le asignamos desde el caracter 0 hasta el espacio en blanco nombre1 
		String nombre1 = nombreCompleto1.substring(0, posicionEspacio1);
		
		// luego como usamos solo el metodo substring con un dato ponemos, que empieza en la posicionEspacio1 + 1 hasta que acabe.
		String apellido1 = nombreCompleto1.substring(posicionEspacio1 +1);
		
		int posicionEspacio2 = nombreCompleto2.indexOf(' ');
		String nombre2 = nombreCompleto2.substring(0, posicionEspacio2);
		String apellido2 = nombreCompleto2.substring(posicionEspacio2 +1);
		
		System.out.println(nombre1 + " " + apellido2);
		System.out.println(nombre2 + " " + apellido1);
		
		
		
	}

}
