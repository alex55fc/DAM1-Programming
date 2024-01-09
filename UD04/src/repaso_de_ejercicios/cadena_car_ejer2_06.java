package repaso_de_ejercicios;

import entrada.Teclado;

public class cadena_car_ejer2_06 {
	
	public static String longitudMaxMin(int longitudMinima, int longitudMaxima, String mensaje) {
		String frase = Teclado.leerCadena(mensaje);
		while (frase.length() < longitudMinima || frase.length() > longitudMaxima) {
			System.out.println("La frase debe estar entre "+ longitudMinima + " y "+ longitudMaxima + " de caraceres");
			frase = Teclado.leerCadena(mensaje);
		}
		return frase;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String frase = longitudMaxMin (5, 10, "Frase: ");
		String mensaje = "";
		for (int posicion = 0; posicion < frase.length() ; posicion++) {
			char caracter = frase.charAt(posicion);
			mensaje =  mensaje + caracter;
			System.out.println(mensaje);
		}
	}

}
