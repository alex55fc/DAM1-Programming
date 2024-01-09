package repaso_de_ejercicios;

import entrada.Teclado;

public class cadena_car_ejer2_08 {
	//necesito saber si empiesa porespacio o acbapor el 
	//teine que haber soloun espacio entre los nombre, ni mas ni menos
	//quiero daber la posicion de un espacio cuando los nombre esten bien

	
	
	
	
	
	
	
	
	// esta mal no entiendo el porque
	public static int contarEspacios (String frase) {
		int contadorEspacios = 0;
		if(frase.startsWith(" ") || frase.endsWith(" ")) {
			for(int pos = 0; pos < frase.length(); pos++) {
				if (frase.charAt(pos) == ' ') {
					contadorEspacios = contadorEspacios + 1;
				}
			}
		}
		return contadorEspacios;
	}

	public static String validarFrase(String mensaje) {
		String frase = Teclado.leerCadena(mensaje);
		while(contarEspacios(frase) != 1) {
			System.out.println("El nombre completo debe tener 1 espacio en blanco.");
			System.out.println("El nombre completo no debe comenzar con un espacio en blanco.");
			System.out.println("El nombre completo no debe terminar con un espacio en blanco.");
			frase = Teclado.leerCadena(mensaje);
		}
		return frase;
	}
	public static void main(String[] args) {
		
		String nombre1 = validarFrase("Nombre completo 1: ");
		String nombre2 = validarFrase("Nombre completo 2: ");
		
		String nombreA = nombre1.substring(0, ' ');
		String nombreB = nombre2.substring(0, ' ');
		
		String apellidoA = nombre1.substring(' ', nombre1.length());
		String apellidoB = nombre1.substring(' ', nombre1.length());
		
		System.out.println(nombreA +" "+ apellidoB );
		System.out.println(nombreB +" "+ apellidoA );
	}
}
